package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Cliente;
import Microservicio.de.Administracion.del.Sistema.model.Soporte;
import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.SoporteService;
import Microservicio.de.Administracion.del.Sistema.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/support/")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;


    @GetMapping("/supervisar")
    @Operation(summary = "Obtiene tickets de soporte.")
    public List<Soporte> getTickets() {
        return soporteService.getTickets();
    }

    @PostMapping("/add")
    @Operation(summary = "Añade tickets de soporte.")
    public String addTicket(@RequestParam Long id_cliente,@RequestBody Soporte ticket) {
        return soporteService.crearTicket(id_cliente,ticket).toString();
    }

    @DeleteMapping("/solve")
    @Operation(summary = "Elimina al solucionar el problema")
    public String solucionar(Long id_ticket) {
        return soporteService.solucionarTicket(id_ticket);
    }
}
