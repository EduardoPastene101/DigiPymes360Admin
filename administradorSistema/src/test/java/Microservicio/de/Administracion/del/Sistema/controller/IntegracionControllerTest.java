package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.Integracion.IntegracionController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IntegracionController.class)
public class IntegracionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testIntegracion() throws Exception {
        // Ejecutar petición
        mockMvc.perform(get("/listarFactura")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
