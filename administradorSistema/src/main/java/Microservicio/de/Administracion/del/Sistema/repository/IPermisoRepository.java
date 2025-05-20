package Microservicio.de.Administracion.del.Sistema.repository;

import Microservicio.de.Administracion.del.Sistema.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermisoRepository extends JpaRepository<Permiso, Long> {
}
