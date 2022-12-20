package com.example.rbd_project.web;

import com.example.rbd_project.model.Pass;
import com.example.rbd_project.service.PassService;
import com.example.rbd_project.web.dto.PassDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pass")
public class PassController {
    private final PassService passService;

    public PassController(PassService passService) {
        this.passService = passService;
    }
    @GetMapping
    public String pass(Model m){
        m.addAttribute("list",passService.getAll());
        return "pass";
    }
    @GetMapping("/delete/{id}")
    public String deletePass(@PathVariable(value = "id") long id){
        passService.deletePassById(id);
        return "redirect:/pass";
    }
    @GetMapping("/newPass")
    public String addPassForm(Model m){
        m.addAttribute("pass",new PassDto());
        return "new_pass";
    }
    @PostMapping("/savePass")
    public String addPass(@ModelAttribute(value = "pass") PassDto passDto) {
        passService.save(passDto);
        return "redirect:/pass/newPass?success";
    }
    @GetMapping("/update/{id}")
    public String updatePass(@PathVariable(value = "id") long id, Model model) {
        Pass pass = passService.findById(id);
        PassDto passDto = new PassDto(pass.getId(), pass.getType());
        model.addAttribute("pass", passDto);
        return "update_pass";
    }
    @PostMapping("/updatePass")
    public String updatePass(@ModelAttribute(value = "pass") PassDto passDto) {
        passService.updatePass(passDto);
        return "redirect:/pass/update/" + passDto.getId() + "?success";
    }
    @GetMapping("/whoClient/{id}")
    public String whoClientPage(Model m, @PathVariable(value = "id") long id) {
        m.addAttribute("list", passService.whoClient(id));
        return "what_clients";
    }
}
