/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.repositories;

import com.example.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 178362
 */
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

}
