package com.pivotal.jishah.pwsspringbootdemo.model;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@Builder
public class Employee {

    public Employee(String name, String department, String city) {
        this.name = name;
        this.city = city;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String department;
    private String city;
}
