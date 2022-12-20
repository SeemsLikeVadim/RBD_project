package com.example.rbd_project.service;


import com.example.rbd_project.model.OrderStatus;
import com.example.rbd_project.web.dto.OrderStatusDto;

import java.util.List;

public interface OrderStatusService {
    OrderStatus save(OrderStatusDto orderStatusDto);
    List<OrderStatus> getAll();

    void deleteOrderStatusById(long id);

    OrderStatus findById(long id);
    OrderStatus updateOrderStatus(OrderStatusDto orderStatusDto);

}
