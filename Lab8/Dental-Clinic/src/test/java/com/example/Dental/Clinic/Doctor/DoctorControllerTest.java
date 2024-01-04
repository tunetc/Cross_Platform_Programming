package com.example.Dental.Clinic.Clinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClinicControllerTest {

    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private ClinicController clinicController;

    @Test
    void testCreateClinic() {
        ClinicEntity clinicEntity = new ClinicEntity();
        when(clinicService.createClinic(any())).thenReturn(clinicEntity);

        ClinicEntity result = clinicController.createClinic(clinicEntity);

        assertNotNull(result);

        verify(clinicService, times(1)).createClinic(clinicEntity);
    }

    @Test
    void testGetAllClinics() {
        ClinicEntity clinic1 = new ClinicEntity();
        ClinicEntity clinic2 = new ClinicEntity();
        List<ClinicEntity> clinicEntities = List.of(clinic1, clinic2);

        when(clinicService.getAllClinics()).thenReturn(clinicEntities);

        List<ClinicEntity> result = clinicController.getAllClinics();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(clinicEntities, result);

        verify(clinicService, times(1)).getAllClinics();
    }

    @Test
    void testGetClinicById() {
        Long clinicId = 1L;
        ClinicEntity clinicEntity = new ClinicEntity();

        when(clinicService.getClinicById(clinicId)).thenReturn(clinicEntity);

        ClinicEntity result = clinicController.getClinicById(clinicId);

        assertNotNull(result);
        assertEquals(clinicEntity, result);

        verify(clinicService, times(1)).getClinicById(clinicId);
    }

    @Test
    void testUpdateClinic() {
        Long clinicId = 1L;
        ClinicEntity updatedClinic = new ClinicEntity();

        when(clinicService.updateClinic(clinicId, updatedClinic)).thenReturn(updatedClinic);

        ClinicEntity result = clinicController.updateClinic(clinicId, updatedClinic);

        assertNotNull(result);
        assertEquals(updatedClinic, result);

        verify(clinicService, times(1)).updateClinic(clinicId, updatedClinic);
    }

    @Test
    void testDeleteClinic() {
        Long clinicId = 1L;

        assertDoesNotThrow(() -> clinicController.deleteClinic(clinicId));

        verify(clinicService, times(1)).deleteClinic(clinicId);
    }
}