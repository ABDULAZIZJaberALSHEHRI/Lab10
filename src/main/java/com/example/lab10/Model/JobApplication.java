package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User id cannot be empty!")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Jop post id cannot be empty!")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;

}
