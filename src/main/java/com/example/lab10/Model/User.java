package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty!")
    @Size(min = 4, message = "name length should be more than 4")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "name must contain only characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @Email(message = "not valid email!")
    @Column(columnDefinition = "varchar(30) unique")
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotNull(message = "Age should not be empty!")
    @Min(value = 21, message = "age must be above '21'!")
    @Positive(message = "age must be positive number")
    @Column(columnDefinition = "int not null")
    private int age;

//    @Column(columnDefinition = "varchar(11) not null check (role='JOB_SEEKER' or role ='EMPLOYER')")
    @NotEmpty(message = "Role cannot be empty!")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$",message = "role must match : 'JOB_SEEKER' or 'EMPLOYER' !")
    @Column(columnDefinition = "varchar(11) not null")
    private String role;
}
