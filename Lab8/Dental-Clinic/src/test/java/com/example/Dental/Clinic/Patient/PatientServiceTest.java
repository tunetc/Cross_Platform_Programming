package com.example.Dental.Clinic.Patient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Test
    void testCreatePatient() {
        PatientEntity patientEntity = new PatientEntity();
        when(patientRepository.save(any())).thenReturn(patientEntity);

        PatientEntity result = patientService.createPatient(patientEntity);

        assertNotNull(result);
    }

    @Test
    void testCreatePatientException() {
        PatientEntity patientEntity = new PatientEntity();
        when(patientRepository.save(any())).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.createPatient(patientEntity));

        assertNotNull(exception);
        assertEquals("Помилка створення пацієнта", exception.getMessage());
        assertNotNull(exception.getCause());
    }

    @Test
    void testGetAllPatients() {
        PatientEntity patient1 = new PatientEntity();
        PatientEntity patient2 = new PatientEntity();

        when(patientRepository.findAll()).thenReturn(List.of(patient1, patient2));

        List<PatientEntity> result = patientService.getAllPatients();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(patient1, result.get(0));
        assertEquals(patient2, result.get(1));

        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void testGetAllPatientsException() {
        when(patientRepository.findAll()).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.getAllPatients());

        assertNotNull(exception);
        assertEquals("Помилка отримання пацієнта", exception.getMessage());
        assertNotNull(exception.getCause());
    }

    @Test
    void testGetPatientById() {
        Long patientId = 1L;
        PatientEntity patientEntity = new PatientEntity();

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(patientEntity));

        PatientEntity result = patientService.getPatientById(patientId);

        assertNotNull(result);
        assertEquals(patientEntity, result);

        verify(patientRepository, times(1)).findById(patientId);
    }

    @Test
    void testGetPatientByIdException() {
        Long patientId = 1L;

        when(patientRepository.findById(patientId)).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.getPatientById(patientId));

        assertNotNull(exception);
        assertEquals("Помилка отримання пацієнта з ID: " + patientId, exception.getMessage());
        assertNotNull(exception.getCause());

        verify(patientRepository, times(1)).findById(patientId);
    }

    @Test
    void testGetPatientByIdNotFound() {
        Long patientId = 1L;

        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        PatientEntity result = patientService.getPatientById(patientId);

        assertNull(result);

        verify(patientRepository, times(1)).findById(patientId);
    }

    @Test
    void testUpdatePatient() {
        Long patientId = 1L;
        PatientEntity existingPatient = new PatientEntity();
        PatientEntity updatedPatient = new PatientEntity();

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(existingPatient));
        when(patientRepository.save(existingPatient)).thenReturn(updatedPatient);

        PatientEntity result = patientService.updatePatient(patientId, updatedPatient);

        assertNotNull(result);
        assertEquals(updatedPatient, result);

        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, times(1)).save(existingPatient);
    }

    @Test
    void testUpdatePatientNotFound() {
        Long patientId = 1L;
        PatientEntity updatedPatient = new PatientEntity();

        when(patientRepository.findById(patientId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.updatePatient(patientId, updatedPatient));

        assertNotNull(exception);
        assertEquals("Помилка оновлення пацієна з ID: " + patientId, exception.getMessage());

        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, never()).save(any());
    }

    @Test
    void testUpdatePatientException() {
        Long patientId = 1L;
        PatientEntity existingPatient = new PatientEntity();
        PatientEntity updatedPatient = new PatientEntity();

        when(patientRepository.findById(patientId)).thenReturn(Optional.of(existingPatient));
        when(patientRepository.save(existingPatient)).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.updatePatient(patientId, updatedPatient));

        assertNotNull(exception);
        assertEquals("Помилка оновлення пацієна з ID: " + patientId, exception.getMessage());
        assertNotNull(exception.getCause());

        verify(patientRepository, times(1)).findById(patientId);
        verify(patientRepository, times(1)).save(existingPatient);
    }

    @Test
    void testDeletePatient() {
        Long patientId = 1L;

        assertDoesNotThrow(() -> patientService.deletePatient(patientId));

        verify(patientRepository, times(1)).deleteById(patientId);
    }

    @Test
    void testDeletePatientException() {
        Long patientId = 1L;

        doThrow(new RuntimeException("Симуляція помилки")).when(patientRepository).deleteById(patientId);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> patientService.deletePatient(patientId));

        assertNotNull(exception);
        assertEquals("Помилка видалення пацієнта з ID: " + patientId, exception.getMessage());
        assertNotNull(exception.getCause());

        verify(patientRepository, times(1)).deleteById(patientId);
    }
}
