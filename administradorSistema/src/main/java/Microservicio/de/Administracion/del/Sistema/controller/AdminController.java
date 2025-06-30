package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PutMapping("/put")
    @Operation(summary = "Modifica rol de usuario.")
    public ResponseEntity<String> modificarUsuario(
            @RequestParam("id_admin") Long idAdmin,
            @RequestBody Usuario usuario,
            @RequestParam("id_usuario") Long idUsuario,
            @RequestParam("rol") Integer nuevoRol
    ) {
        String resultado = adminService.cambiarPermisos(idAdmin, usuario, idUsuario, nuevoRol);
        return ResponseEntity.ok(resultado);
    }

}
