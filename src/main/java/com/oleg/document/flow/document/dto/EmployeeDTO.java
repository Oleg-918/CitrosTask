package com.oleg.document.flow.document.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    private String lastName;
    private String name;
    private String patronymic;
    private String post;

}
