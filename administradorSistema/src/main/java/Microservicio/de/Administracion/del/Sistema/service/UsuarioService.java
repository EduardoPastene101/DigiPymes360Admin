package Microservicio.de.Administracion.del.Sistema.service;


import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final IUsuarioRepository usuarioRepo;

    public UsuarioService(IUsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return  usuarioRepo.findById(id);
    }

    public String crearUsuario(Usuario u){
        u.setRol(3);
        usuarioRepo.save(u);
        return "Usuario creado";
    }

    public void eliminar(Long id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario existente = usuarioRepo.findById(id).orElseThrow();
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setPassword(datos.getPassword());
        existente.setRol(datos.getRol());
        return usuarioRepo.save(existente);
    }
}
