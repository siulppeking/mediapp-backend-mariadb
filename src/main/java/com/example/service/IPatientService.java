package com.example.service;

import com.example.model.Patient;

import java.util.List;

public interface IPatientService extends ICRUD<Patient, Integer> {

    //CRUD: Create, Read, Update, Delete
    /*Patient save(Patient patient) throws Exception;
    Patient update(Integer id, Patient patient) throws Exception;
    List<Patient> findAll() throws Exception;
    Patient findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;*/

    //Patient validAndReturn(Integer id);
}
