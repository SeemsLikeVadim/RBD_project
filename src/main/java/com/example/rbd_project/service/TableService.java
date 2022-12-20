package com.example.rbd_project.service;

import com.example.rbd_project.model.Table;
import com.example.rbd_project.web.dto.TableDto;

import java.util.List;

public interface TableService {
    Table save(TableDto tableDto);
    List<Table> getAll();

    void deleteTableById(long id);

    Table findById(long id);
    Table updateTable(TableDto tableDto);
}
