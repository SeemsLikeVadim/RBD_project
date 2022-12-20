package com.example.rbd_project.service;

import com.example.rbd_project.model.DrinkOrder;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.repository.DrinkOrderRepository;
import com.example.rbd_project.repository.OrderRepository;
import com.example.rbd_project.web.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    final OrderRepository orderRepository;
    final DrinkOrderRepository drinkOrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository, DrinkOrderRepository drinkOrderRepository) {
        this.orderRepository = orderRepository;
        this.drinkOrderRepository = drinkOrderRepository;
    }

    @Override
    public Order save(OrderDto orderDto) {
        Order order = new Order(
                orderDto.getDate(),
                orderDto.getCost()
        );
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order updateOrder(OrderDto orderDto) {
        Order order = findById(orderDto.getId());
        order.setDate(orderDto.getDate());
        order.setCost(orderDto.getCost());
        return orderRepository.save(order);
    }

    @Override
    public List<DrinkOrder> whatDrinks(long id) {
        Order order = findById(id);
        return drinkOrderRepository
                .findAll()
                .stream()
                .filter(drinkOrder -> drinkOrder.getOrder() != null)
                .filter(drinkOrder -> drinkOrder.getOrder().equals(order))
                .collect(Collectors.toList());
    }
}
