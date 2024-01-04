package com.example.Dental.Clinic.Patient;

import com.example.Dental.Clinic.Clinic.ClinicEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Doctor")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialization")
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private ClinicEntity clinic;

    // Constructors, getters, and setters

    public DoctorEntity() {
        // Default constructor needed by JPA
    }

    public DoctorEntity(String name, String specialization, ClinicEntity clinic) {
        this.name = name;
        this.specialization = specialization;
        this.clinic = clinic;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ClinicEntity getClinic() {
        return clinic;
    }

    public void setClinic(ClinicEntity clinic) {
        this.clinic = clinic;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", clinic=" + clinic +
                '}';
    }
}


