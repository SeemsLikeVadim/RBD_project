package com.example.rbd_project.web;

import com.example.rbd_project.model.Table;
import com.example.rbd_project.service.TableService;
import com.example.rbd_project.web.dto.TableDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/table")
public class TableController {
    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }
    @GetMapping
    public String table(Model m){
        m.addAttribute("list",tableService.getAll());
        return "table";
    }
    @GetMapping("/delete/{id}")
    public String deleteTable(@PathVariable(value = "id") long id){
        tableService.deleteTableById(id);
        return "redirect:/table";
    }
    @GetMapping("/newTable")
    public String addTableForm(Model m){
        m.addAttribute("table",new TableDto());
        return "new_table";
    }
    @PostMapping("/saveTable")
    public String addTable(@ModelAttribute(value = "table") TableDto tableDto) {
        tableService.save(tableDto);
        return "redirect:/table/newTable?success";
    }
    @GetMapping("/update/{id}")
    public String updateTable(@PathVariable(value = "id") long id, Model model) {
        Table table = tableService.findById(id);
        TableDto tableDto = new TableDto(table.getId(), table.getRes_time(), table.getAmount_of_people());
        model.addAttribute("table", tableDto);
        return "update_table";
    }
    @PostMapping("/updateTable")
    public String updateTable(@ModelAttribute(value = "table") TableDto tableDto) {
        tableService.updateTable(tableDto);
        return "redirect:/table/update/" + tableDto.getId() + "?success";
    }
}
