package com.example.rbd_project.service;

import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.Order;
import com.example.rbd_project.model.Pass;
import com.example.rbd_project.repository.ClientRepository;
import com.example.rbd_project.repository.OrderRepository;
import com.example.rbd_project.repository.PassRepository;
import com.example.rbd_project.web.dto.ClientDto;
import com.example.rbd_project.web.dto.PassDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    final OrderRepository orderRepository;
    final ClientRepository clientRepository;

    public ClientServiceImpl(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public Client save(ClientDto clientDto) {
        Client client = new Client(
                clientDto.getFio(),
                clientDto.getAge(),
                clientDto.getReg_stat()
        );
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client updateClient(ClientDto clientDto) {
        Client client = findById(clientDto.getId());
        client.setFio(clientDto.getFio());
        client.setAge(clientDto.getAge());
        client.setReg_stat(clientDto.getReg_stat());
        return clientRepository.save(client);
    }

    @Override
    public List<Order> whatOrder(long id) {
        Client client = findById(id);
        return orderRepository
                .findAll()
                .stream()
                .filter(order -> order.getClient() != null)
                .filter(order -> order.getClient().equals(client))
                .collect(Collectors.toList());
    }
}
