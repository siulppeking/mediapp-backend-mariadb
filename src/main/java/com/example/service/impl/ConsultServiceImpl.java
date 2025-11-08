package com.example.service.impl;

import com.example.model.Consult;
import com.example.model.Exam;
import com.example.repo.IConsultExamRepo;
import com.example.repo.IConsultRepo;
import com.example.repo.IGenericRepo;
import com.example.service.IConsultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultServiceImpl extends CRUDImpl<Consult, Integer> implements IConsultService {

    private final IConsultRepo repo;
    private final IConsultExamRepo consultExamRepo;

    @Override
    protected IGenericRepo<Consult, Integer> getRepo() {
        return repo;
    }

    @Transactional
    @Override
    public Consult saveTransactional(Consult consult, List<Exam> exams) {
        repo.save(consult); //GUARDA EL MAESTRO DETALLE
        exams.forEach(ex -> consultExamRepo.saveExam(consult.getIdConsult(), ex.getIdExam()));

        return consult;
    }
}
