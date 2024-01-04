package com.example.Dental.Clinic.Patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public PatientEntity createPatient(@RequestBody PatientEntity patientEntity) {
        logger.info("Створення паціента: {}", patientEntity);
        return patientService.createPatient(patientEntity);
    }

    @GetMapping
    public List<PatientEntity> getAllPatients() {
        logger.info("Отримання всіх пацієнтів");
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientEntity getPatientById(@PathVariable Long id) {
        logger.info("Отримання пацієнта з ID: {}", id);
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientEntity updatePatient(@PathVariable Long id, @RequestBody PatientEntity updatedPatient) {
        logger.info("Оновлення пацієнта з ID {}: {}", id, updatedPatient);
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        logger.info("Видалення пацієнта з ID: {}", id);
        patientService.deletePatient(id);
    }
}
