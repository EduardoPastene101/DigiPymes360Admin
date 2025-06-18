package Microservicio.de.Administracion.del.Sistema.service;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Test
    public void findAll(){
        when(usuarioRepository.findAll()).thenReturn(List.of(new Usuario(1, "Test", "clave", "mail@mail.com", 2, true)));
        List<Usuario> usuarios = usuarioService.findAll();
        assertNotNull(usuarios);
        assertEquals(1, usuarios.size());
    }
}
