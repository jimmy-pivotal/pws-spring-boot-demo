package com.pivotal.jishah.pwsspringbootdemo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Data
public class EmployeeDto {
    private String name;
    private String department;
    private String city;
}
