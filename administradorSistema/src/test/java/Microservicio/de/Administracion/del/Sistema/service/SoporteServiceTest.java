package Microservicio.de.Administracion.del.Sistema.service;

import Microservicio.de.Administracion.del.Sistema.model.Cliente;
import Microservicio.de.Administracion.del.Sistema.model.Soporte;
import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IClienteRepository;
import Microservicio.de.Administracion.del.Sistema.repository.ISoporteRepository;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SoporteServiceTest {
    @Autowired
    private SoporteService soporteService;

    Random random = new Random();
    List<String> estado = new ArrayList<>();

    @Mock
    private ISoporteRepository soporteRepository;

    @Mock
    private IClienteRepository clienteRepo;

    @Mock
    private IUsuarioRepository usuarioRepo;

    Faker faker = new Faker();

    @Test
    public void testgetAllSoportes(){
        when(soporteRepository.findAll()).thenReturn(List.of(new Soporte()));
        List<Soporte> soportes = soporteService.getTickets();
        assertNotNull(soportes);
        assertNotEquals(0, soportes.size());
    }



    @Test
    public void testCrearTicket() {
        estado.clear();
        Long id_usuario = 20L;

        Usuario usuario = new Usuario();
        usuario.setId_usuario(1234);

        Cliente cliente = new Cliente();
        cliente.setId_cliente(usuario.getId_usuario());

        // Mocks con anyLong()
        when(usuarioRepo.findById(anyLong())).thenReturn(Optional.of(usuario));
        when(clienteRepo.findById(anyLong())).thenReturn(Optional.of(cliente));

        // Resto igual
        estado.add("Resuelto");
        estado.add("No resuelto");
        estado.add("En revisión");
        estado.add("Escalado");
        estado.add("Pendiente");
        estado.add("Cerrado");
        estado.add("En espera del cliente");

        Soporte soporte = new Soporte();
        soporte.setId_cliente(cliente);
        soporte.setEstado("Test");

        LocalDate desde = LocalDate.of(2020, 1, 1);
        LocalDate hasta = LocalDate.of(2025, 6, 1);

        long desdeEpoch = desde.toEpochDay();
        long hastaEpoch = hasta.toEpochDay();
        long fechaRandom = random.nextLong(desdeEpoch, hastaEpoch);
        LocalDate fecha = LocalDate.ofEpochDay(fechaRandom);

        Date fechaGenerada = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        soporte.setFecha(fechaGenerada);
        soporte.setMensaje("Mensaje " + random.nextInt(0,999999));

        String soporte_creado = soporteService.crearTicket(id_usuario, soporte);

        assertNotNull(soporte_creado);
        assertTrue(soporte_creado.contains("Ticket creado"), soporte_creado);
    }


}
