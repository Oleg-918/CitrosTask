package com.oleg.document.flow.document.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrganizationDTO {

    private String name;
    private String physicalAddress;
    private String legalAddress;
    private String director;
}
