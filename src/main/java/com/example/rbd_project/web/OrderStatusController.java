package com.example.rbd_project.web;


import com.example.rbd_project.model.OrderStatus;
import com.example.rbd_project.service.OrderStatusService;
import com.example.rbd_project.web.dto.OrderStatusDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/orderStatus")
public class OrderStatusController {
    private final OrderStatusService orderStatusService;

    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }
    @GetMapping
    public String orderStatus(Model m){
        m.addAttribute("list",orderStatusService.getAll());
        return "orderStatus";
    }
    @GetMapping("/delete/{id}")
    public String deleteOrderStatus(@PathVariable(value = "id") long id){
        orderStatusService.deleteOrderStatusById(id);
        return "redirect:/orderStatus";
    }
    @GetMapping("/newOrderStatus")
    public String addOrderStatusForm(Model m){
        m.addAttribute("orderStatus",new OrderStatusDto());
        return "new_orderStatus";
    }
    @PostMapping("/saveOrderStatus")
    public String addOrderStatus(@ModelAttribute(value = "orderStatus") OrderStatusDto orderStatusDto) {
        orderStatusService.save(orderStatusDto);
        return "redirect:/orderStatus/newOrderStatus?success";
    }
    @GetMapping("/update/{id}")
    public String updateOrderStatus(@PathVariable(value = "id") long id, Model model) {
        OrderStatus orderStatus = orderStatusService.findById(id);
        OrderStatusDto orderStatusDto = new OrderStatusDto(orderStatus.getId(), orderStatus.getTitle());
        model.addAttribute("orderStatus", orderStatusDto);
        return "update_orderStatus";
    }
    @PostMapping("/updateOrderStatus")
    public String updateOrderStatus(@ModelAttribute(value = "orderStatus") OrderStatusDto orderStatusDto) {
        orderStatusService.updateOrderStatus(orderStatusDto);
        return "redirect:/orderStatus/update/" + orderStatusDto.getId() + "?success";
    }
}
