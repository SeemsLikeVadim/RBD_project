package com.example.rbd_project.service;

import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.DrinkOrder;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.web.dto.ClientDto;
import com.example.rbd_project.web.dto.OrderDto;

import java.util.List;

public interface OrderService {
    Order save(OrderDto orderDto);
    List<Order> getAll();

    void deleteOrderById(long id);

    Order findById(long id);
    Order updateOrder(OrderDto orderDto);

    List<DrinkOrder> whatDrinks(long id);
}
