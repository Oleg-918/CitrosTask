package com.oleg.document.flow.document.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastName")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String lastName;

    @Column(name = "name")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String name;

    @Column(name = "patronymic")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String patronymic;

    @Column(name = "post")
    @NotEmpty(message = "The field should not be empty")
    //@Size(min = 2, max = 32, message = "Field must be between 2 and 32 characters long")
    private String post;

    //Связь между таблицами
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_order",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name="employee_id")// назвать столбец правильно
    private Division division;

    @ManyToOne
    @JoinColumn(name="employee_id_organization")
    private Organization organization;

}
