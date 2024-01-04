package com.example.Dental.Clinic.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientEntity createPatient(PatientEntity patientEntity) {
        try {
            return patientRepository.save(patientEntity);
        } catch (Exception e) {
            throw new RuntimeException("Помилка створення пацієнта", e);
        }
    }

    public List<PatientEntity> getAllPatients() {
        try {
            return patientRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання пацієнта", e);
        }
    }

    public PatientEntity getPatientById(Long id) {
        try {
            return patientRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання пацієнта з ID: " + id, e);
        }
    }

    public PatientEntity updatePatient(Long id, PatientEntity updatedPatient) {
        try {
            PatientEntity existingPatient = patientRepository.findById(id).orElse(null);

            if (existingPatient != null) {
                existingPatient.setName(updatedPatient.getName());
                existingPatient.setAge(updatedPatient.getAge());
                existingPatient.setSex(updatedPatient.getSex());
                existingPatient.setDoctor(updatedPatient.getDoctor());
                return patientRepository.save(existingPatient);
            } else {
                throw new RuntimeException("Пацієнт не знайдений ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка оновлення пацієна з ID: " + id, e);
        }
    }

    public void deletePatient(Long id) {
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Помилка видалення пацієнта з ID: " + id, e);
        }
    }
}
