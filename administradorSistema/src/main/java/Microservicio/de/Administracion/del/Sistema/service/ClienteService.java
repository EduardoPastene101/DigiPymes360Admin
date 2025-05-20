package Microservicio.de.Administracion.del.Sistema.service;


import Microservicio.de.Administracion.del.Sistema.model.Cliente;
import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import Microservicio.de.Administracion.del.Sistema.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    private final IClienteRepository ClienteRepo;

    public ClienteService(IClienteRepository ClienteRepo) {
        this.ClienteRepo = ClienteRepo;
    }

    public String cambiarPermisos(Long id_admin, Usuario admin, Long id_cliente) {
        Optional<Usuario> cliente = ClienteRepo.findById(id_cliente);
        Optional<Usuario> administrador = ClienteRepo.findById(id_admin);

        
        String str = "";

        if (administrador.getId_usuario()){

        }

        return str;
    }

}
