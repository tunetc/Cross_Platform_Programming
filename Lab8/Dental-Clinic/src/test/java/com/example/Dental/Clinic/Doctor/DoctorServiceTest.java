package com.example.Dental.Clinic.Clinic;

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
class ClinicServiceTest {

    @Mock
    private ClinicRepository clinicRepository;

    @InjectMocks
    private ClinicService clinicService;

    @Test
    void testCreateClinic() {
        ClinicEntity clinicEntity = new ClinicEntity();
        when(clinicRepository.save(any())).thenReturn(clinicEntity);

        ClinicEntity result = clinicService.createClinic(clinicEntity);

        assertNotNull(result);

        when(clinicRepository.save(any())).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> clinicService.createClinic(clinicEntity));

        assertEquals("Помилка додавання клініки", exception.getMessage());
        assertNotNull(exception.getCause());
    }

    @Test
    void testGetAllClinics() {
        ClinicEntity clinic1 = new ClinicEntity();
        ClinicEntity clinic2 = new ClinicEntity();
        List<ClinicEntity> clinicEntities = List.of(clinic1, clinic2);

        when(clinicRepository.findAll()).thenReturn(clinicEntities);

        List<ClinicEntity> result = clinicService.getAllClinics();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(clinicEntities, result);

        verify(clinicRepository, times(1)).findAll();
    }

    @Test
    void testGetAllClinicsException() {
        when(clinicRepository.findAll()).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> clinicService.getAllClinics());

        assertNotNull(exception);
        assertEquals("Помилка отримання клінік", exception.getMessage());
        assertNotNull(exception.getCause());
        assertTrue(exception.getCause() instanceof RuntimeException);

        verify(clinicRepository, times(1)).findAll();
    }

    void testGetClinicById() {
        Long clinicId = 1L;
        ClinicEntity clinicEntity = new ClinicEntity();

        when(clinicRepository.findById(clinicId)).thenReturn(Optional.of(clinicEntity));

        ClinicEntity result = clinicService.getClinicById(clinicId);

        assertNotNull(result);
        assertEquals(clinicEntity, result);

        verify(clinicRepository, times(1)).findById(clinicId);
    }

    @Test
    void testGetClinicByIdNotFound() {
        Long clinicId = 1L;

        when(clinicRepository.findById(clinicId)).thenReturn(Optional.empty());

        ClinicEntity result = clinicService.getClinicById(clinicId);

        assertNull(result);

        verify(clinicRepository, times(1)).findById(clinicId);
    }

    @Test
    void testGetClinicByIdException() {
        Long clinicId = 1L;

        when(clinicRepository.findById(clinicId)).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> clinicService.getClinicById(clinicId));

        assertNotNull(exception);
        assertEquals("Помилка отримання клініки з ID: " + clinicId, exception.getMessage());
        assertNotNull(exception.getCause());
        assertTrue(exception.getCause() instanceof RuntimeException);

        verify(clinicRepository, times(1)).findById(clinicId);
    }

    @Test
    void testUpdateClinic() {
        Long clinicId = 1L;
        ClinicEntity existingClinic = new ClinicEntity();
        ClinicEntity updatedClinic = new ClinicEntity();

        when(clinicRepository.findById(clinicId)).thenReturn(Optional.of(existingClinic));
        when(clinicRepository.save(any())).thenReturn(updatedClinic);

        ClinicEntity result = clinicService.updateClinic(clinicId, updatedClinic);

        assertNotNull(result);
        assertEquals(updatedClinic.getName(), result.getName());
        assertEquals(updatedClinic.getLocation(), result.getLocation());

        verify(clinicRepository, times(1)).findById(clinicId);
        verify(clinicRepository, times(1)).save(existingClinic);
    }

    @Test
    void testUpdateClinicNotFound() {
        Long clinicId = 1L;
        ClinicEntity updatedClinic = new ClinicEntity();

        when(clinicRepository.findById(clinicId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> clinicService.updateClinic(clinicId, updatedClinic));

        assertNotNull(exception);
        assertEquals("Помилка оновлення клініки з ID: " + clinicId, exception.getMessage());

        verify(clinicRepository, times(1)).findById(clinicId);
        verify(clinicRepository, never()).save(any());
    }

    @Test
    void testUpdateClinicException() {
        Long clinicId = 1L;
        ClinicEntity existingClinic = new ClinicEntity();
        ClinicEntity updatedClinic = new ClinicEntity();

        when(clinicRepository.findById(clinicId)).thenReturn(Optional.of(existingClinic));
        when(clinicRepository.save(any())).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> clinicService.updateClinic(clinicId, updatedClinic));

        assertNotNull(exception);
        assertEquals("Помилка оновлення клініки з ID: " + clinicId, exception.getMessage());
        assertNotNull(exception.getCause());
        assertTrue(exception.getCause() instanceof RuntimeException);

        verify(clinicRepository, times(1)).findById(clinicId);
        verify(clinicRepository, times(1)).save(existingClinic);
    }

    @Test
    void testDeleteClinic() {
        Long clinicId = 1L;

        assertDoesNotThrow(() -> clinicService.deleteClinic(clinicId));

        verify(clinicRepository, times(1)).deleteById(clinicId);
    }

    @Test
    void testDeleteClinicException() {
        Long clinicId = 1L;

        doThrow(new RuntimeException("Емуляція помилки")).when(clinicRepository).deleteById(clinicId);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> clinicService.deleteClinic(clinicId));

        assertNotNull(exception);
        assertEquals("Помилка видалення клініки з ID: " + clinicId, exception.getMessage());
        assertNotNull(exception.getCause());
        assertTrue(exception.getCause() instanceof RuntimeException);

        verify(clinicRepository, times(1)).deleteById(clinicId);
    }
}
