/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 178362
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private Integer idPatient;

    @NotNull
    @Size(min = 3, max = 70, message = "{firstname.size}")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 70, message = "{lastname.size}")
    private String lastName;

    @NotNull
    private String dni;

    @NotNull
    private String address;

    @NotNull
    @Pattern(regexp = "[0-9]+", message = "{phone.regex}")
    private String phone;

    @NotNull
    @Email(message = "{email.valid}")
    private String email;

    /*@NotEmpty
    @NotBlank
    @Size(min = 3, max = 50)
    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")

    @Min(value = 1)
    @Max(value = 100)
    private int age;*/
}
