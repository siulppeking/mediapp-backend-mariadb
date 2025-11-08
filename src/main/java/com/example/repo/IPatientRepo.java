package com.example.repo;

import com.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends IGenericRepo<Patient, Integer> {

    //Patient getPatientById(Integer id);
}
