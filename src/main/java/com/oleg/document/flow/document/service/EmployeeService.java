package com.oleg.document.flow.document.service;

import com.oleg.document.flow.document.dto.EmployeeDTO;
import com.oleg.document.flow.document.model.Employee;
import com.oleg.document.flow.document.repository.EmployeeRepository;
import com.oleg.document.flow.document.util.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeDTO(employee);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
        return employeeMapper.toEmployeeDTO(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
