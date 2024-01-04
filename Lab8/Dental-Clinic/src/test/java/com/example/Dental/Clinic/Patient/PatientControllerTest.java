package com.example.Dental.Clinic.Doctor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    @Test
    void testCreateDoctor() {
        DoctorEntity doctorEntity = new DoctorEntity();
        when(doctorService.createDoctor(any())).thenReturn(doctorEntity);

        DoctorEntity result = doctorController.createDoctor(doctorEntity);

        assertNotNull(result);

        verify(doctorService, times(1)).createDoctor(doctorEntity);
    }

    @Test
    void testGetAllDoctors() {
        DoctorEntity doctor1 = new DoctorEntity();
        DoctorEntity doctor2 = new DoctorEntity();
        List<DoctorEntity> doctorEntities = List.of(doctor1, doctor2);

        when(doctorService.getAllDoctors()).thenReturn(doctorEntities);

        List<DoctorEntity> result = doctorController.getAllDoctors();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(doctorEntities, result);

        verify(doctorService, times(1)).getAllDoctors();
    }

    @Test
    void testGetDoctorById() {
        Long doctorId = 1L;
        DoctorEntity doctorEntity = new DoctorEntity();

        when(doctorService.getDoctorById(doctorId)).thenReturn(doctorEntity);

        DoctorEntity result = doctorController.getDoctorById(doctorId);

        assertNotNull(result);
        assertEquals(doctorEntity, result);

        verify(doctorService, times(1)).getDoctorById(doctorId);
    }

    @Test
    void testUpdateDoctor() {
        Long doctorId = 1L;
        DoctorEntity updatedDoctor = new DoctorEntity();

        when(doctorService.updateDoctor(doctorId, updatedDoctor)).thenReturn(updatedDoctor);

        DoctorEntity result = doctorController.updateDoctor(doctorId, updatedDoctor);

        assertNotNull(result);
        assertEquals(updatedDoctor, result);

        verify(doctorService, times(1)).updateDoctor(doctorId, updatedDoctor);
    }

    @Test
    void testDeleteDoctor() {
        Long doctorId = 1L;

        assertDoesNotThrow(() -> doctorController.deleteDoctor(doctorId));

        verify(doctorService, times(1)).deleteDoctor(doctorId);
    }
}
