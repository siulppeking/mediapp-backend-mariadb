package com.example.service.impl;

import com.example.model.Patient;
import com.example.repo.IGenericRepo;
import com.example.repo.IPatientRepo;
import com.example.service.IPatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements IPatientService {

    //@Autowired
    private final IPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
    //private String text;



    /*@Override
    public Patient save(Patient patient) throws Exception {
        return repo.save(patient);
    }

    @Override
    public Patient update(Integer id, Patient patient) throws Exception {
        //DEPENDE DEL ID
        patient.setIdPatient(id);
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }*/

    /*public PatientService(PatientRepo repo) {
        this.repo = repo;
    }*/

    /*@Override
    public Patient validAndReturn(Integer id){
        if(id > 0){
            //repo = new PatientRepo();
            return repo.getPatientById(id);
        }else{
            return new Patient();
        }
    }*/
}
