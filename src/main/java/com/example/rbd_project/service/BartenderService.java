package com.example.rbd_project.service;



import com.example.rbd_project.model.Bartender;
import com.example.rbd_project.web.dto.BartenderDto;

import java.util.List;

public interface BartenderService {
    Bartender save(BartenderDto bartenderDto);
    List<Bartender> getAll();

    void deleteBartenderById(long id);

    Bartender findById(long id);
    Bartender updateBartender(BartenderDto bartenderDto);
}
