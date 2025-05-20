package Microservicio.de.Administracion.del.Sistema.service;


import Microservicio.de.Administracion.del.Sistema.repository.IClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final IClienteRepository perroRepo;

    public ClienteService(IClienteRepository perroRepo) {
        this.perroRepo = perroRepo;
    }


}
