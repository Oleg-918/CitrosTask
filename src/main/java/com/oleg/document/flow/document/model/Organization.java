package com.oleg.document.flow.document.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "organization")
@Data
@NoArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String name;

    @Column(name = "physical_address")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 64, message = "Field must be between 2 and 32 characters long")
    private String physicalAddress;

    @Column(name = "legal_address")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 64, message = "Field must be between 2 and 32 characters long")
    private String legalAddress;

    @Column(name = "director")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String director;

    //Связь между таблицами
    @OneToMany(mappedBy="organization")
    private Set<Division> divisionSet;

    @OneToMany(mappedBy="organization")
    private Set<Employee> employeeSet;//нахуя?
}
