package com.example.rbd_project.service;

import com.example.rbd_project.model.DrinkOrder;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.web.dto.DrinkOrderDto;
import com.example.rbd_project.web.dto.OrderDto;

import java.util.List;

public interface DrinkOrderService {
    DrinkOrder save(DrinkOrderDto drinkOrderDto);
    List<DrinkOrder> getAll();

    void deleteDrinkOrderById(long id);

    DrinkOrder findById(long id);
    DrinkOrder updateDrinkOrder(DrinkOrderDto drinkOrderDto);

}
