package Microservicio.de.Administracion.del.Sistema.repository;

import Microservicio.de.Administracion.del.Sistema.model.UsuarioPermiso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioPermisoRepository extends JpaRepository<UsuarioPermiso, Long> {
}
