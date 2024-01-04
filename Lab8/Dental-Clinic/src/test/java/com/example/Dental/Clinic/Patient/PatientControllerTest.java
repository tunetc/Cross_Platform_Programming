package com.example.Dental.Clinic.Patient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @Test
    void testCreatePatient() {
        PatientEntity patientEntity = new PatientEntity();
        when(patientService.createPatient(any())).thenReturn(patientEntity);

        PatientEntity result = patientController.createPatient(patientEntity);

        assertNotNull(result);
    }

    @Test
    void testGetAllPatients() {
        PatientEntity patient1 = new PatientEntity();
        PatientEntity patient2 = new PatientEntity();
        List<PatientEntity> patientEntities = List.of(patient1, patient2);

        when(patientService.getAllPatients()).thenReturn(patientEntities);

        List<PatientEntity> result = patientController.getAllPatients();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(patientEntities, result);

        verify(patientService, times(1)).getAllPatients();
    }

    @Test
    void testGetPatientById() {
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();

        when(patientService.getPatientById(patientId)).thenReturn(patientEntity);

        PatientEntity result = patientController.getPatientById(patientId);

        assertNotNull(result);
        assertEquals(patientEntity, result);

        verify(patientService, times(1)).getPatientById(patientId);
    }

    @Test
    void testUpdatePatient() {
        Long patientId = 1L;
        PatientEntity existingPatient = new PatientEntity();
        PatientEntity updatedPatient = new PatientEntity();

        when(patientService.updatePatient(patientId, updatedPatient)).thenReturn(updatedPatient);

        PatientEntity result = patientController.updatePatient(patientId, updatedPatient);

        assertNotNull(result);
        assertEquals(updatedPatient, result);

        verify(patientService, times(1)).updatePatient(patientId, updatedPatient);
    }

    @Test
    void testDeletePatient() {
        Long patientId = 1L;

        assertDoesNotThrow(() -> patientController.deletePatient(patientId));

        verify(patientService, times(1)).deletePatient(patientId);
    }
}