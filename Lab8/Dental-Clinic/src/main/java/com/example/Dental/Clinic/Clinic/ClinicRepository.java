package com.example.Dental.Clinic.Clinic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<ClinicEntity, Long> {

}