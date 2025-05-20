package Microservicio.de.Administracion.del.Sistema.repository;

import Microservicio.de.Administracion.del.Sistema.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
