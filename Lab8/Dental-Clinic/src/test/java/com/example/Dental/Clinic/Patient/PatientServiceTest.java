package com.example.Dental.Clinic.Doctor;

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
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    void testCreateDoctor() {
        DoctorEntity doctorEntity = new DoctorEntity();
        when(doctorRepository.save(any())).thenReturn(doctorEntity);

        DoctorEntity result = doctorService.createDoctor(doctorEntity);

        assertNotNull(result);

        when(doctorRepository.save(any())).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.createDoctor(doctorEntity));

        assertEquals("Помилка створення лікаря", exception.getMessage());
        assertNotNull(exception.getCause());
    }

    @Test
    void testGetAllDoctors() {
        DoctorEntity doctor1 = new DoctorEntity();
        DoctorEntity doctor2 = new DoctorEntity();
        List<DoctorEntity> doctorEntities = List.of(doctor1, doctor2);

        when(doctorRepository.findAll()).thenReturn(doctorEntities);

        List<DoctorEntity> result = doctorService.getAllDoctors();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(doctorEntities, result);

        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testGetDoctorById() {
        Long doctorId = 1L;
        DoctorEntity doctorEntity = new DoctorEntity();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(doctorEntity));

        DoctorEntity result = doctorService.getDoctorById(doctorId);

        assertNotNull(result);
        assertEquals(doctorEntity, result);

        verify(doctorRepository, times(1)).findById(doctorId);
    }

    @Test
    void testGetDoctorByIdNotFound() {
        Long doctorId = 1L;

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        DoctorEntity result = doctorService.getDoctorById(doctorId);

        assertNull(result);

        verify(doctorRepository, times(1)).findById(doctorId);
    }

    @Test
    void testGetAllDoctorsException() {
        when(doctorRepository.findAll()).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.getAllDoctors());

        assertNotNull(exception);
        assertEquals("Помилка отримання лікарів", exception.getMessage());
        assertNotNull(exception.getCause());

        verify(doctorRepository, times(1)).findAll();
    }

    @Test
    void testGetDoctorByIdException() {
        Long doctorId = 1L;

        when(doctorRepository.findById(doctorId)).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.getDoctorById(doctorId));

        assertNotNull(exception);
        assertEquals("Помилка отримання лікаря з ID: " + doctorId, exception.getMessage());
        assertNotNull(exception.getCause());

        verify(doctorRepository, times(1)).findById(doctorId);
    }


    @Test
    void testUpdateDoctor() {
        Long doctorId = 1L;
        DoctorEntity existingDoctor = new DoctorEntity();
        DoctorEntity updatedDoctor = new DoctorEntity();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(existingDoctor));
        when(doctorRepository.save(any())).thenReturn(updatedDoctor);

        DoctorEntity result = doctorService.updateDoctor(doctorId, updatedDoctor);

        assertNotNull(result);
        assertEquals(updatedDoctor.getName(), result.getName());
        assertEquals(updatedDoctor.getSpecialization(), result.getSpecialization());
        assertEquals(updatedDoctor.getClinic(), result.getClinic());

        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorRepository, times(1)).save(existingDoctor);
    }

    @Test
    void testUpdateDoctorNotFound() {
        Long doctorId = 1L;
        DoctorEntity updatedDoctor = new DoctorEntity();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.updateDoctor(doctorId, updatedDoctor));

        assertNotNull(exception);
        assertEquals("Помилка оновлення лікаря з ID: " + doctorId, exception.getMessage());

        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorRepository, never()).save(any());
    }

    @Test
    void testUpdateDoctorException() {
        Long doctorId = 1L;
        DoctorEntity existingDoctor = new DoctorEntity();
        DoctorEntity updatedDoctor = new DoctorEntity();

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(existingDoctor));
        when(doctorRepository.save(any())).thenThrow(new RuntimeException("Симуляція помилки"));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.updateDoctor(doctorId, updatedDoctor));

        assertNotNull(exception);
        assertEquals("Помилка оновлення лікаря з ID: " + doctorId, exception.getMessage());
        assertNotNull(exception.getCause());
    }

    @Test
    void testDeleteDoctor() {
        Long doctorId = 1L;

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(new DoctorEntity()));

        assertDoesNotThrow(() -> doctorService.deleteDoctor(doctorId));

        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorRepository, times(1)).deleteById(doctorId);
    }

    @Test
    void testDeleteDoctorNotFound() {
        Long doctorId = 1L;

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.deleteDoctor(doctorId));

        assertNotNull(exception);
        assertEquals("Помилка видалеення ID: " + doctorId, exception.getMessage());

        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorRepository, never()).deleteById(any());
    }

    @Test
    void testDeleteDoctorException() {
        Long doctorId = 1L;

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(new DoctorEntity()));
        doThrow(new RuntimeException("Симуляція помилки")).when(doctorRepository).deleteById(doctorId);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> doctorService.deleteDoctor(doctorId));

        assertNotNull(exception);
        assertEquals("Помилка видалеення ID: " + doctorId, exception.getMessage());
        assertNotNull(exception.getCause());

        verify(doctorRepository, times(1)).findById(doctorId);
        verify(doctorRepository, times(1)).deleteById(doctorId);
    }
}
