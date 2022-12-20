package com.example.rbd_project.service;


import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.web.dto.ClientDto;


import java.util.List;

public interface ClientService {
    Client save(ClientDto clientDto);
    List<Client> getAll();

    void deleteClientById(long id);

    Client findById(long id);
    Client updateClient(ClientDto clientDto);

    List<Order> whatOrder(long id);
}
