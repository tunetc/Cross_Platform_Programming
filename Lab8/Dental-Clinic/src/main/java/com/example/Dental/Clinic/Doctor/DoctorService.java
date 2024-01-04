package com.example.Dental.Clinic.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {
        try {
            return doctorRepository.save(doctorEntity);
        } catch (Exception e) {
            throw new RuntimeException("Помилка створення лікаря", e);
        }
    }

    public List<DoctorEntity> getAllDoctors() {
        try {
            return doctorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання лікарів", e);
        }
    }

    public DoctorEntity getDoctorById(Long id) {
        try {
            return doctorRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Помилка отримання лікаря з ID: " + id, e);
        }
    }

    public DoctorEntity updateDoctor(Long id, DoctorEntity updatedDoctor) {
        try {
            DoctorEntity existingDoctor = doctorRepository.findById(id).orElse(null);

            if (existingDoctor != null) {
                existingDoctor.setName(updatedDoctor.getName());
                existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
                existingDoctor.setClinic(updatedDoctor.getClinic());
                return doctorRepository.save(existingDoctor);
            } else {
                throw new RuntimeException("Лікаря не знайдено ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка оновлення лікаря з ID: " + id, e);
        }
    }

    public void deleteDoctor(Long id) {
        try {
            Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(id);

            if (optionalDoctor.isPresent()) {
                doctorRepository.deleteById(id);
            } else {
                throw new RuntimeException("Лікаря не знайдено ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Помилка видалеення ID: " + id, e);
        }
    }
}
