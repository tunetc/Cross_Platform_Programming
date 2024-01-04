package com.example.Dental.Clinic.Doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorEntity createDoctor(@RequestBody DoctorEntity doctorEntity) {
        logger.info("Створення лікаря: {}", doctorEntity);
        return doctorService.createDoctor(doctorEntity);
    }

    @GetMapping
    public List<DoctorEntity> getAllDoctors() {
        logger.info("Отримання всіх лікарів");
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorEntity getDoctorById(@PathVariable Long id) {
        logger.info("Отримання лікаря по ID: {}", id);
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public DoctorEntity updateDoctor(@PathVariable Long id, @RequestBody DoctorEntity updatedDoctor) {
        logger.info("Оновлення лікаря з ID {}: {}", id, updatedDoctor);
        return doctorService.updateDoctor(id, updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        logger.info("Видалення лікаря з ID: {}", id);
        doctorService.deleteDoctor(id);
    }
}
