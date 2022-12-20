package com.example.rbd_project.service;


import com.example.rbd_project.model.OrderStatus;
import com.example.rbd_project.repository.OrderStatusRepository;
import com.example.rbd_project.web.dto.OrderStatusDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{
    final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderStatus save(OrderStatusDto orderStatusDto) {
        OrderStatus orderStatus = new OrderStatus(
                orderStatusDto.getTitle()
        );
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public List<OrderStatus> getAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public void deleteOrderStatusById(long id) {
        orderStatusRepository.deleteById(id);
    }

    @Override
    public OrderStatus findById(long id) {
        return orderStatusRepository.findById(id).get();
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatusDto orderStatusDto) {
        OrderStatus orderStatus = findById(orderStatusDto.getId());
        orderStatus.setTitle(orderStatusDto.getTitle());
        return orderStatusRepository.save(orderStatus);
    }
}
