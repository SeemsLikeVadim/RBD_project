package com.example.rbd_project.web;


import com.example.rbd_project.model.BarCard;
import com.example.rbd_project.model.Client;
import com.example.rbd_project.service.BarCardService;
import com.example.rbd_project.service.ClientService;
import com.example.rbd_project.web.dto.BarCardDto;
import com.example.rbd_project.web.dto.ClientDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/barCard")
public class BarCardController {
    private final BarCardService barCardService;

    public BarCardController(BarCardService barCardService) {
        this.barCardService = barCardService;
    }
    @GetMapping
    public String barCard(Model m){
        m.addAttribute("list",barCardService.getAll());
        return "barCard";
    }
    @GetMapping("/delete/{id}")
    public String deleteBarCard(@PathVariable(value = "id") long id){
        barCardService.deleteBarCardById(id);
        return "redirect:/barCard";
    }
    @GetMapping("/newBarCard")
    public String addBarCardForm(Model m){
        m.addAttribute("barCard",new BarCardDto());
        return "new_barCard";
    }
    @PostMapping("/saveBarCard")
    public String addBarCard(@ModelAttribute(value = "barCard") BarCardDto barCardDto) {
        barCardService.save(barCardDto);
        return "redirect:/barCard/newBarCard?success";
    }
    @GetMapping("/update/{id}")
    public String updateBarCard(@PathVariable(value = "id") long id, Model model) {
        BarCard barCard = barCardService.findById(id);
        BarCardDto barCardDto = new BarCardDto(barCard.getId(), barCard.getTitle(), barCard.getPrice(), barCard.getAlcohol());
        model.addAttribute("barCard", barCardDto);
        return "update_barCard";
    }
    @PostMapping("/updateBarCard")
    public String updateBarCard(@ModelAttribute(value = "barCard") BarCardDto barCardDto) {
        barCardService.updateBarCard(barCardDto);
        return "redirect:/barCard/update/" + barCardDto.getId() + "?success";
    }
}
