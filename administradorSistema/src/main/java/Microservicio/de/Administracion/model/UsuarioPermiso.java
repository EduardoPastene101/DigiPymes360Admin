package Microservicio.de.Administracion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario_Permiso")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPermiso {
    @JoinColumn(name = "id_usuario")
    private Integer id_usuario;

    @JoinColumn(name = "id_permiso")
    private Integer id_permiso;
}
