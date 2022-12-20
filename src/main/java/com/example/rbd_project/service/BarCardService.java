package com.example.rbd_project.service;


import com.example.rbd_project.model.BarCard;
import com.example.rbd_project.web.dto.BarCardDto;
import com.example.rbd_project.web.dto.ClientDto;

import java.util.List;

public interface BarCardService {
    BarCard save(BarCardDto barCardDto);
    List<BarCard> getAll();

    void deleteBarCardById(long id);

    BarCard findById(long id);
    BarCard updateBarCard(BarCardDto barCardDto);

}
