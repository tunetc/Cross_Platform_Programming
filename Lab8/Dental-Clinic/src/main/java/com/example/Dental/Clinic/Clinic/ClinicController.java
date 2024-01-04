package com.example.Dental.Clinic.Clinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private static final Logger logger = LoggerFactory.getLogger(ClinicController.class);

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping
    public ClinicEntity createClinic(@RequestBody ClinicEntity clinicEntity) {
        logger.info("Створення клініки: {}", clinicEntity);
        return clinicService.createClinic(clinicEntity);
    }

    @GetMapping
    public List<ClinicEntity> getAllClinics() {
        logger.info("Отримання всіх клінік");
        return clinicService.getAllClinics();
    }

    @GetMapping("/{id}")
    public ClinicEntity getClinicById(@PathVariable Long id) {
        logger.info("Отримання клініки по ID: {}", id);
        return clinicService.getClinicById(id);
    }

    @PutMapping("/{id}")
    public ClinicEntity updateClinic(@PathVariable Long id, @RequestBody ClinicEntity updatedClinic) {
        logger.info("Оновлення клініки по ID {}: {}", id, updatedClinic);
        return clinicService.updateClinic(id, updatedClinic);
    }

    @DeleteMapping("/{id}")
    public void deleteClinic(@PathVariable Long id) {
        logger.info("Видалення клініки з ID: {}", id);
        clinicService.deleteClinic(id);
    }
}
