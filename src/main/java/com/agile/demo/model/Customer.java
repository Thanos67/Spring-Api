package com.agile.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="firstName")
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;
    @Column(name="lastName")
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    @Column(name="emailName")
    @NotNull
    @Size(min = 2, max = 50)
    @Email
    private String email;
}