package com.example.rbd_project.web;



import com.example.rbd_project.model.Order;
import com.example.rbd_project.service.OrderService;
import com.example.rbd_project.web.dto.OrderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public String order(Model m){
        m.addAttribute("list",orderService.getAll());
        return "order";
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable(value = "id") long id){
        orderService.deleteOrderById(id);
        return "redirect:/order";
    }
    @GetMapping("/newOrder")
    public String addOrderForm(Model m){
        m.addAttribute("order",new OrderDto());
        return "new_order";
    }
    @PostMapping("/saveOrder")
    public String addOrder(@ModelAttribute(value = "order") OrderDto orderDto) {
        orderService.save(orderDto);
        return "redirect:/order/newOrder?success";
    }
    @GetMapping("/update/{id}")
    public String updateOrder(@PathVariable(value = "id") long id, Model model) {
        Order order = orderService.findById(id);
        OrderDto orderDto = new OrderDto(order.getId(), order.getDate(), order.getCost());
        model.addAttribute("order", orderDto);
        return "update_order";
    }
    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute(value = "order") OrderDto orderDto) {
        orderService.updateOrder(orderDto);
        return "redirect:/order/update/" + orderDto.getId() + "?success";
    }
    @GetMapping("/whatDrinks/{id}")
    public String whatDrinks(Model m, @PathVariable(value = "id") long id) {
        m.addAttribute("list", orderService.whatDrinks(id));
        return "what_drinks";
    }
}
