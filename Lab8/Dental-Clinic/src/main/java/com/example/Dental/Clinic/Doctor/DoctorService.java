package com.example.Dental.Clinic.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public List<ClinicEntity> getAllClinics() {
        return clinicRepository.findAll();
    }

    public ClinicEntity getClinicById(Long id) {
        return clinicRepository.findById(id).orElse(null);
    }
}
