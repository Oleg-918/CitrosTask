package com.oleg.document.flow.document.controller;

import com.oleg.document.flow.document.dto.EmployeeDTO;
import com.oleg.document.flow.document.model.Employee;
import com.oleg.document.flow.document.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public EmployeeDTO create(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping("/employeen/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee")
    public EmployeeDTO update(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(employeeDTO);
    }

    @GetMapping("/employee")
    public List<Employee> getAll() {
        return employeeService.getAllEmployee();
    }
}
