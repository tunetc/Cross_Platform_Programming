package com.example.Dental.Clinic.Clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public ClinicEntity createClinic(ClinicEntity clinicEntity) {
        try {
            return clinicRepository.save(clinicEntity);
        } catch (Exception e) {
            throw new RuntimeException("Помилка додавання клініки", e);
        }
    }

    public List<ClinicEntity> getAllClinics() {
        try {
            return clinicRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання клінік", e);
        }
    }

    public ClinicEntity getClinicById(Long id) {
        try {
            Optional<ClinicEntity> optionalClinic = clinicRepository.findById(id);
            return optionalClinic.orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання клініки з ID: " + id, e);
        }
    }

    public ClinicEntity updateClinic(Long id, ClinicEntity updatedClinic) {
        try {
            ClinicEntity existingClinic = clinicRepository.findById(id).orElse(null);

            if (existingClinic != null) {
                existingClinic.setName(updatedClinic.getName());
                existingClinic.setLocation(updatedClinic.getLocation());
                return clinicRepository.save(existingClinic);
            } else {
                throw new RuntimeException("Clinic not found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка оновлення клініки з ID: " + id, e);
        }
    }

    public void deleteClinic(Long id) {
        try {
            clinicRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Помилка видалення клініки з ID: " + id, e);
        }
    }
}
