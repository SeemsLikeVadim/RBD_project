package com.example.rbd_project.service;

import com.example.rbd_project.model.Table;
import com.example.rbd_project.repository.TableRepository;
import com.example.rbd_project.web.dto.TableDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService{
    final
    TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public Table save(TableDto tableDto) {
        Table deputy = new Table(
                tableDto.getRes_time(),
                tableDto.getAmount_of_people()
        );
        return tableRepository.save(deputy);
    }

    @Override
    public List<Table> getAll() {
        return tableRepository.findAll();
    }

    @Override
    public void deleteTableById(long id) {
        tableRepository.deleteById(id);
    }

    @Override
    public Table findById(long id) {
        return tableRepository.findById(id).get();
    }

    @Override
    public Table updateTable(TableDto tableDto) {
        Table table = findById(tableDto.getId());
        table.setRes_time(tableDto.getRes_time());
        table.setAmount_of_people(tableDto.getAmount_of_people());
        return tableRepository.save(table);
    }
}
