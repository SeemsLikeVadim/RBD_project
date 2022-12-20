package com.example.rbd_project.web;


import com.example.rbd_project.model.Bartender;
import com.example.rbd_project.service.BartenderService;
import com.example.rbd_project.web.dto.BartenderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/bartender")
public class BartenderController {
    private final BartenderService bartenderService;

    public BartenderController(BartenderService bartenderService) {
        this.bartenderService = bartenderService;
    }
    @GetMapping
    public String bartender(Model m){
        m.addAttribute("list",bartenderService.getAll());
        return "bartender";
    }
    @GetMapping("/delete/{id}")
    public String deleteBartender(@PathVariable(value = "id") long id){
        bartenderService.deleteBartenderById(id);
        return "redirect:/bartender";
    }
    @GetMapping("/newBartender")
    public String addBartenderForm(Model m){
        m.addAttribute("bartender",new BartenderDto());
        return "new_bartender";
    }
    @PostMapping("/saveBartender")
    public String addBartender(@ModelAttribute(value = "bartender") BartenderDto bartenderDto) {
        bartenderService.save(bartenderDto);
        return "redirect:/bartender/newBartender?success";
    }
    @GetMapping("/update/{id}")
    public String updateBartender(@PathVariable(value = "id") long id, Model model) {
        Bartender bartender = bartenderService.findById(id);
        BartenderDto bartenderDto = new BartenderDto(bartender.getId(), bartender.getFio(), bartender.getWor_exp(), bartender.getPhone_number(), bartender.getSalary());
        model.addAttribute("bartender", bartenderDto);
        return "update_bartender";
    }
    @PostMapping("/updateBartender")
    public String updateBartender(@ModelAttribute(value = "bartender")BartenderDto bartenderDto) {
        bartenderService.updateBartender(bartenderDto);
        return "redirect:/bartender/update/" + bartenderDto.getId() + "?success";
    }
}
