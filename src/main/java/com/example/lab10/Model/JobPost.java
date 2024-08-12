package com.example.lab10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be empty!")
    @Size(min = 4,message = "Title length must be more than 4 chars!")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;

    @NotEmpty(message = "Description cannot be empty!")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    @NotEmpty(message = "Location should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String location;

    @NotNull(message = "Salary should not be empty!")
    @Positive(message = "Salary must be non-negative number!")
    @Column(columnDefinition = "double not null")
    private Double salary;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "varchar(15)")
    private LocalDate postingDate;
}
