package com.example.rbd_project.service;



import com.example.rbd_project.model.Bartender;
import com.example.rbd_project.repository.BartenderRepository;
import com.example.rbd_project.web.dto.BartenderDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BartenderServiceImpl implements BartenderService {
    final BartenderRepository bartenderRepository;

    public BartenderServiceImpl(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }


    @Override
    public Bartender save(BartenderDto bartenderDto) {
        Bartender bartender = new Bartender(
                bartenderDto.getFio(),
                bartenderDto.getWor_exp(),
                bartenderDto.getPhone_number(),
                bartenderDto.getSalary()
        );
        return bartenderRepository.save(bartender);
    }

    @Override
    public List<Bartender> getAll() {
        return bartenderRepository.findAll();
    }

    @Override
    public void deleteBartenderById(long id) {
        bartenderRepository.deleteById(id);
    }

    @Override
    public Bartender findById(long id) {
        return bartenderRepository.findById(id).get();
    }

    @Override
    public Bartender updateBartender(BartenderDto bartenderDto) {
        Bartender bartender = findById(bartenderDto.getId());
        bartender.setFio(bartenderDto.getFio());
        bartender.setWor_exp(bartenderDto.getWor_exp());
        bartender.setPhone_number(bartenderDto.getPhone_number());
        bartender.setSalary(bartenderDto.getSalary());
        return bartenderRepository.save(bartender);
    }
}
