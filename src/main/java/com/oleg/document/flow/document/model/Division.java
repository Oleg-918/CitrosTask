package com.oleg.document.flow.document.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "division")
@Data
@NoArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String name;

    @Column(name = "contactDetails")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private Long contactDetails;

    @Column(name = "director")
    @NotEmpty(message = "The field should not be empty")
    @Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String director;

    //Связь между таблицами
    @ManyToOne
    @JoinColumn(name="division_id", nullable=false)
    private Organization organization;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employeeSet;

}
