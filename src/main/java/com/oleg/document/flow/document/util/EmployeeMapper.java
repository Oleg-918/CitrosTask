package com.oleg.document.flow.document.util;

import com.oleg.document.flow.document.dto.EmployeeDTO;
import com.oleg.document.flow.document.model.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    EmployeeDTO toEmployeeDTO(Employee employee);
    Employee toEmployee(EmployeeDTO employeeDTO);

}
