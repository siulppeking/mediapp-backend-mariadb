/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dto;

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
public class PatientUpdDto {

    private Integer idPatient;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

}
