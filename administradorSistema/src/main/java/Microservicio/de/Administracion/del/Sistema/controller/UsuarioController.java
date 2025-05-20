package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Usuario/")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/add")
    @Operation(summary = "Añade usuario.")
    public String addUsuario(@RequestBody Usuario usuario) {
        return this.usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/get")
    @Operation(summary = "Obtiene usuarios.")
    public List<Usuario> getUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "obtiene usuario por id.")
    public String getById(@PathVariable Long id) {
        String str = "";

        if (this.usuarioService.obtenerPorId(id).isEmpty()){
            str = "No hay coincidencias";
        }else{
            str = this.usuarioService.obtenerPorId(id).toString();
        }
        return str;
    }

    @PutMapping("/put/{id}")
    @Operation(summary = "Modifica usuarios.")
    public String modificarUsuario(@PathVariable Long id,@RequestBody Usuario usuario) {
        this.usuarioService.actualizar(id,usuario);
        return "Datos actualizados correctamente.";
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "Elimina usuarios.")
    public String eliminarUsuario(@PathVariable Long id) {
        this.usuarioService.eliminar(id);
        return "Datos eliminados correctamente.";
    }
}
