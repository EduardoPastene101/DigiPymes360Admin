package Microservicio.de.Administracion.del.Sistema.service;

import org.springframework.dao.DataIntegrityViolationException;
import Microservicio.de.Administracion.del.Sistema.model.Cliente;
import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IClienteRepository;
import Microservicio.de.Administracion.del.Sistema.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final IUsuarioRepository usuarioRepo;
    private final IClienteRepository clienteRepo;

    public UsuarioService(IUsuarioRepository usuarioRepo, IClienteRepository clienteRepo) {
        this.usuarioRepo = usuarioRepo;
        this.clienteRepo = clienteRepo;
    }

    public List<Usuario> findAll() {

        List<Usuario> usuarios =  usuarioRepo.findAll();

        for (int i = 0;i < usuarios.size();i++){
            Usuario obtenerUsuario = usuarios.get(i);
            obtenerUsuario.setEmail("");
            obtenerUsuario.setPassword("");
            usuarios.set(i,obtenerUsuario);
        }

        return usuarios;

    }



    public Usuario obtenerPorId(Long id) {
        String ret = "Permiso denegado.";
        Usuario u = usuarioRepo.findById(id).get();
        u.setPassword("");
        u.setEmail("");
        //ret = u.toString();

        return u;

    }

    public Usuario crearUsuario(Usuario u, String direccion, String telefono) {
            if (!usuarioRepo.findAll().isEmpty()) {
                u.setRol(3); // cliente por defecto (Después se puede modificar)
            } else {
                u.setRol(0); // admin
            }
            u.setId_usuario(null);
            // Guarda primero el usuario (asigna ID)
            usuarioRepo.save(u);

            if (u.getRol() == 3) {
                Cliente cliente = new Cliente();
                cliente.setId_usuario(u); // Usuario ya tiene ID
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                clienteRepo.save(cliente);
            }

            return u;
    }

    public String eliminarVoluntariamente(Long id, Usuario usuario) {
        String ret = "No se puede eliminar el usuario.";

        Optional<Usuario> usuario_get = usuarioRepo.findById(id);



        if (usuario_get.isPresent()
                && usuario.getPassword().equals(usuario_get.get().getPassword())
                && usuario.getEmail().equals(usuario_get.get().getEmail()) &&
                usuario_get.get().getId_usuario().equals(usuario.getId_usuario())) {

            Usuario usuarioEncontrado = usuario_get.get();

            List<Cliente> clientes = clienteRepo.findAll();
            for (Cliente c : clientes) {
                if (c.getId_usuario().getId_usuario().equals(usuarioEncontrado.getId_usuario())) {
                    clienteRepo.delete(c);
                    break;
                }
            }

            usuarioRepo.deleteById(id);
            ret = "Usuario eliminado.";
        }

        return ret;
    }

    public boolean loginDP360(String email, String password) {

        List<Usuario> usuarios =  usuarioRepo.findAll();

        boolean ret = false;
        for (int i = 0;i < usuarios.size();i++){

            Usuario obtenerUsuario = usuarios.get(i);

            if (obtenerUsuario.getEmail().equals(email) && obtenerUsuario.getPassword().equals(password)) {
                ret = true;
            }
        }

        return ret;

    }

    public String eliminarUsuario(Long id,Long id_admin, Usuario admin) {
        String ret = "No se puede eliminar el usuario.";

        Optional<Usuario> check_admin = usuarioRepo.findById(id_admin);

        if (check_admin.isPresent()
                && admin.getPassword().equals(check_admin.get().getPassword())
                && admin.getEmail().equals(check_admin.get().getEmail())
                && check_admin.get().getRol()==0) {

            Usuario usuarioEncontrado = usuarioRepo.findById(id).get();

            List<Cliente> clientes = clienteRepo.findAll();
            for (Cliente c : clientes) {
                if (c.getId_usuario().getId_usuario().equals(usuarioEncontrado.getId_usuario())) {
                    clienteRepo.delete(c);
                    break;
                }
            }

            usuarioRepo.deleteById(id);
            ret = "Usuario eliminado.";
        }

        return ret;
    }





    public Usuario actualizar(Long id, Usuario datos, String nueva_password,String nuevo_email) {
        String str = "No se pudo actualizar.";
        Usuario usuario = usuarioRepo.findById(id).get();
        if (usuario.getPassword().equals(datos.getPassword())
                && usuario.getEmail().equals(datos.getEmail())
                && usuario.isActivo()) {
            usuario.setPassword(nueva_password);
            usuario.setEmail(nuevo_email);
            usuario.setNombre(datos.getNombre());
            usuarioRepo.save(usuario);
            str = "Usuario actualizado.";
        }
        return usuario;
    }

    public Usuario actualizarActivarDesactivar(Long id,Long id_admin, Usuario datos, boolean activar) {
        Usuario usuario = usuarioRepo.findById(id).get();
        Usuario admin = usuarioRepo.findById(id_admin).get();

        if (admin.getPassword().equals(datos.getPassword())
                && admin.getEmail().equals(datos.getEmail())
                && admin.getRol()==0) {
            usuario.setActivo(activar);
            usuarioRepo.save(usuario);
        }
        return usuario;
    }

}
