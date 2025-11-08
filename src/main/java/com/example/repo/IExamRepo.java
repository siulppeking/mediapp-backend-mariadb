package com.example.repo;

import com.example.model.Exam;
import com.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExamRepo extends IGenericRepo<Exam, Integer> {

}
