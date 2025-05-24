package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Cliente;
import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    @Operation(summary = "Añade usuario.")
    public String addUsuario(@RequestBody Usuario usuario,@RequestParam String direccion, @RequestParam String telefono) {
        return this.usuarioService.crearUsuario(usuario,direccion,telefono);
    }

    @GetMapping("/get")
    @Operation(summary = "Obtiene usuarios.")
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/getbyid")
    @Operation(summary = "obtiene usuario por id.")
    public String getById(@RequestParam Long id) {

        return this.usuarioService.obtenerPorId(id);
    }

    @PutMapping("/put")
    @Operation(summary = "Modifica usuarios.")
    public String modificarUsuario(@RequestParam Long id,@RequestBody Usuario usuario, @RequestParam String nueva_password, @RequestParam String nuevo_email) {
        this.usuarioService.actualizar(id,usuario,nueva_password,nuevo_email);
        return "Datos actualizados correctamente.";
    }

    @DeleteMapping("/del")
    @Operation(summary = "Elimina usuarios.")
    public String eliminarUsuario(@RequestParam Long id, @RequestParam Long id_admin, @RequestBody Usuario admin) {
        this.usuarioService.eliminarUsuario(id,id_admin, admin);
        return "Datos eliminados correctamente.";
    }

    @DeleteMapping("/delself")
    @Operation(summary = "Elimina usuario cuando el usuario quiera eliminarse.")
    public String eliminarUsuarioVoluntariamente(@RequestParam Long id, @RequestBody Usuario usuario) {
        this.usuarioService.eliminarVoluntariamente(id,usuario);
        return "Datos eliminados correctamente.";
    }
}
