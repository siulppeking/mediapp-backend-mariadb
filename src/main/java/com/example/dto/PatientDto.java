/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;

import com.example.entities.PatientEntity;
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
public class PatientDto {

    private Integer idPatient;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public static PatientDto fromEntity(PatientEntity p) {
        return new PatientDto(p.getIdPatient(), p.getFirstName(), p.getLastName(), p.getAddress(), p.getPhone());
    }

}
