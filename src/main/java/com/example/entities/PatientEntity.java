/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 178362
 */
@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;
    
    @Column(nullable = false, length = 20)
    private String firstName;
    
    @Column(nullable = false, length = 20)
    private String lastName;
    
    @Column(nullable = false, length = 50)
    private String address;
    
    @Column(nullable = false, length = 9)
    private String phone;

}
