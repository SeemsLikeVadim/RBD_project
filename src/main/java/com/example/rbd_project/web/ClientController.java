package com.example.rbd_project.web;

import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.Pass;
import com.example.rbd_project.service.ClientService;
import com.example.rbd_project.service.PassService;
import com.example.rbd_project.web.dto.ClientDto;
import com.example.rbd_project.web.dto.PassDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping
    public String client(Model m){
        m.addAttribute("list",clientService.getAll());
        return "client";
    }
    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable(value = "id") long id){
        clientService.deleteClientById(id);
        return "redirect:/client";
    }
    @GetMapping("/newClient")
    public String addClientForm(Model m){
        m.addAttribute("client",new ClientDto());
        return "new_client";
    }
    @PostMapping("/saveClient")
    public String addClient(@ModelAttribute(value = "client") ClientDto clientDto) {
        clientService.save(clientDto);
        return "redirect:/client/newClient?success";
    }
    @GetMapping("/update/{id}")
    public String updateClient(@PathVariable(value = "id") long id, Model model) {
        Client client = clientService.findById(id);
        ClientDto clientDto = new ClientDto(client.getId(), client.getFio(), client.getAge(), client.getReg_stat());
        model.addAttribute("client", clientDto);
        return "update_client";
    }
    @PostMapping("/updateClient")
    public String updateClient(@ModelAttribute(value = "client") ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return "redirect:/client/update/" + clientDto.getId() + "?success";
    }
    @GetMapping("/whatOrder/{id}")
    public String whoClientPage(Model m, @PathVariable(value = "id") long id) {
        m.addAttribute("list", clientService.whatOrder(id));
        return "what_orders";
    }
}
