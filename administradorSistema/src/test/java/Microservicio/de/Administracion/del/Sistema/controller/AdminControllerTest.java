package Microservicio.de.Administracion.del.Sistema.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario admin;

    @BeforeEach
    void setUp() {
        admin = new Usuario();
        admin.setId_usuario(1);
        admin.setEmail("mack.will@yahoo.com");
        admin.setPassword("51gh79ve80t3a");
        admin.setRol(0);
    }

    @Test
    public void testCambiarPermisos() throws Exception {
        Long idAdmin = 1L;
        Long idUsuario = 5L;
        Integer nuevoRol = 3;

        // Simular el comportamiento del servicio
        when(adminService.cambiarPermisos(idAdmin, admin, idUsuario, nuevoRol))
                .thenReturn("Rol cambiado satisfactoriamente");

        // Ejecutar petición
        mockMvc.perform(put("/api/v1/admin/put")
                        .param("idAdmin", "1")
                        .param("idUsuario", "5")
                        .param("nuevoRol", "3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isOk())
                .andExpect(content().string("Rol cambiado satisfactoriamente"));

    }
}
