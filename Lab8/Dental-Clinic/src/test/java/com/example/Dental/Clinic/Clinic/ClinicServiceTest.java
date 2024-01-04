package com.example.Dental.Clinic.Clinic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(ClinicController.class)
class ClinicEntityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClinicService clinicService;

    @Test
    void createClinic() throws Exception {
        ClinicEntity clinicEntity = new ClinicEntity();

        when(clinicService.createClinic(any(ClinicEntity.class))).thenReturn(clinicEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/clinics")
                        .contentType("application/json")
                        .content("{}")) // pass your JSON payload here
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getAllClinics() throws Exception {
        when(clinicService.getAllClinics()).thenReturn(List.of(new ClinicEntity(), new ClinicEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get("/clinics"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getClinicById() throws Exception {
        Long clinicId = 1L;
        when(clinicService.getClinicById(clinicId)).thenReturn(new ClinicEntity());

        mockMvc.perform(MockMvcRequestBuilders.get("/clinics/{id}", clinicId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateClinic() throws Exception {
        Long clinicId = 1L;
        ClinicEntity updatedClinic = new ClinicEntity(); // create a sample updated ClinicEntity

        when(clinicService.updateClinic(eq(clinicId), any(ClinicEntity.class))).thenReturn(updatedClinic);

        mockMvc.perform(MockMvcRequestBuilders.put("/clinics/{id}", clinicId)
                        .contentType("application/json")
                        .content("{}")) // pass your JSON payload here
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteClinic() throws Exception {
        Long clinicId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/clinics/{id}", clinicId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(clinicService, times(1)).deleteClinic(clinicId);
    }
}
