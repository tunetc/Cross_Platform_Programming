package com.example.Dental.Clinic.Clinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public List<ClinicEntity> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @GetMapping("/{id}")
    public ClinicEntity getClinicById(@PathVariable Long id) {
        return clinicService.getClinicById(id);
    }
}
