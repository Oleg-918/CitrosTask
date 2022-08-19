package com.oleg.document.flow.document.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
    private String subjectAssignment;
    private String director;
    private String employee;
    private String termExecution;
    private String signExecution;
    private String textOrder;
    private String status;
}
