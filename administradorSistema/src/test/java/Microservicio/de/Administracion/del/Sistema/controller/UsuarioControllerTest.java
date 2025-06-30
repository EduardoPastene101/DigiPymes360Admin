package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.AdminService;
import Microservicio.de.Administracion.del.Sistema.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminService adminService;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario admin,usuario;
    @MockBean
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        admin = new Usuario();
        admin.setId_usuario(1);
        admin.setEmail("mack.will@yahoo.com");
        admin.setPassword("51gh79ve80t3a");
        admin.setRol(0);

        usuario = new Usuario();
        usuario.setId_usuario(2);
        usuario.setEmail("pat.braun@gmail.com");
        usuario.setPassword("5q7a36zk6698cge");
        usuario.setRol(1);

    }

    @Test
    public void testAddUsuario() throws Exception {

        // Ejecutar petición
        mockMvc.perform(post("/api/v1/user/add")
                        .param("direccion", "calle 123")
                        .param("telefono", "12345")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin)))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetUsuarios() throws Exception {
        when(usuarioService.findAll()).thenReturn(List.of(new Usuario()));
        // Ejecutar petición
        mockMvc.perform(get("/api/v1/user/get"))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetById() throws Exception {
        when(usuarioService.obtenerPorId(1L)).thenReturn(admin.toString());
        // Ejecutar petición
        mockMvc.perform(get("/api/v1/user/getbyid")
                .param("id","1")
                )
                .andExpect(status().isOk());

    }

    @Test
    public void testModificarUsuario() throws Exception {
        when(usuarioService.actualizar(2L,admin,"pass123","pat.braun@gmail.com")).thenReturn(admin.toString());

        // Ejecutar petición
        mockMvc.perform(put("/api/v1/user/put")
                        .param("id","2")
                        .param("nuevo_email","pat.braun@gmail.com")
                        .param("nueva_password","pass123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario))
                )
                .andExpect(status().isOk());

    }

    @Test
    public void testModificarUsuarioActivarDesactivar() throws Exception {
        when(usuarioService.actualizarActivarDesactivar(2L,1L,admin,false)).thenReturn(admin.toString());
        // Ejecutar petición
        mockMvc.perform(put("/api/v1/user/deactivate")
                        .param("id","2")
                        .param("id_admin","1")
                        .param("activar","0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin))
                )
                .andExpect(status().isOk());

    }

    @Test
    public void testEliminarUsuario() throws Exception {
        //doNothing().when(usuarioService).eliminarUsuario(2L,1L,admin);//Lo tiene en string, así que el donothing no sirve
        mockMvc.perform(delete("/api/v1/user/del")
                        .param("id","2")
                        .param("id_admin","1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin))
                )
                .andExpect(status().isOk());
        //verify(usuarioService, times(1)).eliminarUsuario(2L,1L,admin);
    }

    @Test
    public void testEliminarUsuarioVoluntariamente() throws Exception {
        //doNothing().when(usuarioService).eliminarVoluntariamente(2L,usuario);//Lo tiene en string, así que el donothing no sirve
        mockMvc.perform(delete("/api/v1/user/delself")
                        .param("id","2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario))
                )
                .andExpect(status().isOk());
        //verify(usuarioService, times(1)).eliminarVoluntariamente(2L,usuario);
    }
}
