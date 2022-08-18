package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.dto.DivisionDTO;
import com.oleg.document.flow.document.model.Division;
import com.oleg.document.flow.document.service.DivisionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class DivisionController {
    private final DivisionService divisionService;

    @PostMapping("/division")
    public DivisionDTO create(@RequestBody @Valid DivisionDTO divisionDTO) {
        return divisionService.createNewDivision(divisionDTO);
    }

    @DeleteMapping("/division/{id}")
    public void delete(@PathVariable("id") Integer id) {
        divisionService.deleteDivision(id);
    }

    @PutMapping("/division")
    public DivisionDTO update(@RequestBody @Valid DivisionDTO divisionDTO) {
        return divisionService.updateDivision(divisionDTO);
    }

    @GetMapping("/division")
    public List<Division> getAll() {
        return divisionService.getAllDivision();
    }
}
