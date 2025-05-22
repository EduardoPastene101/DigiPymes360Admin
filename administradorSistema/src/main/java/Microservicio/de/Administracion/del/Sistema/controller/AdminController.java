package Microservicio.de.Administracion.del.Sistema.controller;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PutMapping("/put/{id}")
    @Operation(summary = "Modifica rol de usuario.")
    public String modificarUsuario(@RequestParam Long id_admin,@RequestBody Usuario admin,@RequestParam Long id_cliente, @RequestParam Integer rol) {

        return this.adminService.cambiarPermisos(id_admin,admin,id_cliente,rol);
    }

}
