package com.example.rbd_project.service;

import com.example.rbd_project.model.BarCard;
import com.example.rbd_project.model.Client;
import com.example.rbd_project.repository.BarCardRepository;
import com.example.rbd_project.repository.ClientRepository;
import com.example.rbd_project.repository.OrderRepository;
import com.example.rbd_project.web.dto.BarCardDto;
import com.example.rbd_project.web.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarCardServiceImpl implements BarCardService{
    final BarCardRepository barCardRepository;

    public BarCardServiceImpl(BarCardRepository barCardRepository) {
        this.barCardRepository = barCardRepository;
    }

    @Override
    public BarCard save(BarCardDto barCardDto) {
        BarCard barCard = new BarCard(
                barCardDto.getTitle(),
                barCardDto.getPrice(),
                barCardDto.getAlcohol()
        );
        return barCardRepository.save(barCard);
    }

    @Override
    public List<BarCard> getAll() {
        return barCardRepository.findAll();
    }

    @Override
    public void deleteBarCardById(long id) {
        barCardRepository.deleteById(id);
    }

    @Override
    public BarCard findById(long id) {
        return barCardRepository.findById(id).get();
    }

    @Override
    public BarCard updateBarCard(BarCardDto barCardDto) {
        BarCard barCard = findById(barCardDto.getId());
        barCard.setTitle(barCardDto.getTitle());
        barCard.setPrice(barCardDto.getPrice());
        barCard.setAlcohol(barCardDto.getAlcohol());
        return barCardRepository.save(barCard);
    }
}
