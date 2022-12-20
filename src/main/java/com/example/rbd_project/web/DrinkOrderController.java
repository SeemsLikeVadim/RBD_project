package com.example.rbd_project.web;


import com.example.rbd_project.model.DrinkOrder;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.service.DrinkOrderService;
import com.example.rbd_project.service.OrderService;
import com.example.rbd_project.web.dto.DrinkOrderDto;
import com.example.rbd_project.web.dto.OrderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drinkOrder")
public class DrinkOrderController {
    private final DrinkOrderService drinkOrderService;

    public DrinkOrderController(DrinkOrderService drinkOrderService) {
        this.drinkOrderService = drinkOrderService;
    }
    @GetMapping
    public String drinkOrder(Model m){
        m.addAttribute("list",drinkOrderService.getAll());
        return "drinkOrder";
    }
    @GetMapping("/delete/{id}")
    public String deleteDrinkOrder(@PathVariable(value = "id") long id){
        drinkOrderService.deleteDrinkOrderById(id);
        return "redirect:/drinkOrder";
    }
    @GetMapping("/newDrinkOrder")
    public String addDrinkOrderForm(Model m){
        m.addAttribute("drinkOrder",new DrinkOrderDto());
        return "new_drinkOrder";
    }
    @PostMapping("/saveDrinkOrder")
    public String addDrinkOrder(@ModelAttribute(value = "drinkOrder") DrinkOrderDto drinkOrderDto) {
        drinkOrderService.save(drinkOrderDto);
        return "redirect:/drinkOrder/newDrinkOrder?success";
    }
    @GetMapping("/update/{id}")
    public String updateDrinkOrder(@PathVariable(value = "id") long id, Model model) {
        DrinkOrder drinkOrder = drinkOrderService.findById(id);
        DrinkOrderDto drinkOrderDto = new DrinkOrderDto(drinkOrder.getId(),drinkOrder.getCost());
        model.addAttribute("drinkOrder", drinkOrderDto);
        return "update_drinkOrder";
    }
    @PostMapping("/updateDrinkOrder")
    public String updateDrinkOrder(@ModelAttribute(value = "order") DrinkOrderDto drinkOrderDto) {
        drinkOrderService.updateDrinkOrder(drinkOrderDto);
        return "redirect:/drinkOrder/update/" + drinkOrderDto.getId() + "?success";
    }

}
