package com.example.Dental.Clinic.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorEntity getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
}
