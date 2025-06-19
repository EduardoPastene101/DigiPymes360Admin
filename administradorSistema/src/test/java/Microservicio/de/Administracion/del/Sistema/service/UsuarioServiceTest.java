package Microservicio.de.Administracion.del.Sistema.service;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;

    @Mock
    private IUsuarioRepository usuarioRepository;

    Faker faker = new Faker();
    @Test
    public void testfindAll(){
        when(usuarioRepository.findAll()).thenReturn(List.of(new Usuario()));
        List<Usuario> usuarios = usuarioService.findAll();
        assertNotNull(usuarios);
        assertNotEquals(0, usuarios.size());
    }

    @Test
    public void testObtenerPorId(){
        Long id = 20L;
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(new Usuario()));

        String usuario_obtenido = usuarioService.obtenerPorId(id);
        assertNotNull(usuario_obtenido);
        assertTrue(usuario_obtenido.contains("Usuario"));

    }

    @Test
    public void testCrearUsuario(){
        Usuario usuario = new Usuario();

        usuario.setActivo(true);

        String nombre_simulado=faker.name().fullName(),
                email_simulado=faker.internet().emailAddress(),
                password_simulada = faker.internet().password(10,15);

        usuario.setNombre(nombre_simulado);
        usuario.setEmail(email_simulado);
        usuario.setRol(3);
        usuario.setPassword(password_simulada);

        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        String usuario_creado = usuarioService.crearUsuario(usuario,"direccion","123");//Datos de ingreso de usuario ficticios
        assertNotNull(usuario_creado);
        assertTrue(usuario_creado.contains("Usuario creado correctamente."),usuario_creado);

    }

}
