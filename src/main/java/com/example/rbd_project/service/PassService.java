package com.example.rbd_project.service;

import com.example.rbd_project.model.Client;
import com.example.rbd_project.model.Pass;
import com.example.rbd_project.web.dto.PassDto;

import java.util.List;

public interface PassService {
    Pass save(PassDto passDto);
    List<Pass> getAll();

    void deletePassById(long id);

    Pass findById(long id);
    Pass updatePass(PassDto passDto);

    List<Client> whoClient(long id);
}
