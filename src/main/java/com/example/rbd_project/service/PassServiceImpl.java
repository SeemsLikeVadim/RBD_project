package com.example.rbd_project.service;


import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.Pass;
import com.example.rbd_project.repository.ClientRepository;
import com.example.rbd_project.repository.PassRepository;
import com.example.rbd_project.web.dto.PassDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassServiceImpl implements PassService{

    final PassRepository passRepository;
    final ClientRepository clientRepository;

    public PassServiceImpl(PassRepository passRepository, ClientRepository clientRepository) {
        this.passRepository = passRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Pass save(PassDto passDto) {
        Pass pass = new Pass(
                passDto.getType()
        );
        return passRepository.save(pass);
    }

    @Override
    public List<Pass> getAll() {
        return passRepository.findAll();
    }

    @Override
    public void deletePassById(long id) {
        passRepository.deleteById(id);
    }

    @Override
    public Pass findById(long id) {
        return passRepository.findById(id).get();
    }

    @Override
    public Pass updatePass(PassDto passDto) {
        Pass pass = findById(passDto.getId());
        pass.setType(passDto.getType());
        return passRepository.save(pass);
    }

    @Override
    public List<Client> whoClient(long id) {
        Pass pass = findById(id);
        return clientRepository
                .findAll()
                .stream()
                .filter(client -> client.getPass() != null)
                .filter(client -> client.getPass().equals(pass))
                .collect(Collectors.toList());
    }
}
