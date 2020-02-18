package com.pivotal.jishah.pwsspringbootdemo.model;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String department;
    private String city;
}
