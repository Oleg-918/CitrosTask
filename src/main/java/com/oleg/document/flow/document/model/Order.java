package com.oleg.document.flow.document.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subject_assignment")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 64, message = "Field must be between 2 and 32 characters long")
    private String subjectAssignment;

    @Column(name = "director")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String director;

    @Column(name = "employee")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String employee;

    @Column(name = "term_execution")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String termExecution;

    @Column(name = "sign_execution")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String signExecution;

    @Column(name = "status")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String status = "Start";

    @Column(name = "order_text")
    @NotEmpty(message = "The field should not be empty")
    //@Min(value = 0, message = "Field should not be less than 0")
    private String textOrder;

    //Связь между таблицами
    @ManyToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Employee> employees;
}
