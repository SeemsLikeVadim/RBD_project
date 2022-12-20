package com.example.rbd_project.service;

import com.example.rbd_project.model.DrinkOrder;
import com.example.rbd_project.repository.DrinkOrderRepository;
import com.example.rbd_project.web.dto.DrinkOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkOrderImpl implements DrinkOrderService{

    final
    DrinkOrderRepository drinkOrderRepository;

    public DrinkOrderImpl(DrinkOrderRepository drinkOrderRepository) {
        this.drinkOrderRepository = drinkOrderRepository;
    }

    @Override
    public DrinkOrder save(DrinkOrderDto drinkOrderDto) {
        DrinkOrder drinkOrder = new DrinkOrder(
                drinkOrderDto.getCost()
        );
        return drinkOrderRepository.save(drinkOrder);
    }

    @Override
    public List<DrinkOrder> getAll() {
        return drinkOrderRepository.findAll();
    }

    @Override
    public void deleteDrinkOrderById(long id) {
        drinkOrderRepository.deleteById(id);
    }

    @Override
    public DrinkOrder findById(long id) {
        return drinkOrderRepository.findById(id).get();
    }

    @Override
    public DrinkOrder updateDrinkOrder(DrinkOrderDto drinkOrderDto) {
        DrinkOrder drinkOrder = findById(drinkOrderDto.getId());
        drinkOrder.setCost(drinkOrderDto.getCost());
        return drinkOrderRepository.save(drinkOrder);
    }
}
