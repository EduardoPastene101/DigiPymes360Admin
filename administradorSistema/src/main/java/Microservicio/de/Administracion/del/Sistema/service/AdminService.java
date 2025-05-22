package Microservicio.de.Administracion.del.Sistema.service;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IPermisoRepository;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioPermisoRepository;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminService {
    private final IUsuarioRepository UsuarioRepo;
    private final IUsuarioPermisoRepository UsuarioPermisoRepo;
    private final IPermisoRepository PermisoRepo;

    public String cambiarPermisos(Long id_admin, Usuario admin, Long id_cliente, Integer rol) {
        String str;

        Optional<Usuario> usuario_admin = UsuarioRepo.findById(id_admin);

        if (admin.getPassword().equals(usuario_admin.get().getPassword())
                && admin.getRol().equals(0)){
                Usuario usuario_a_modificar = UsuarioRepo.findById(id_cliente).get();
                usuario_a_modificar.setRol(rol);
                UsuarioRepo.save(usuario_a_modificar);

                str = "Rol cambiado satisfactoriamente";

        }else{
            str = "Permiso denegado.";
        }
        return str;
    }

}
