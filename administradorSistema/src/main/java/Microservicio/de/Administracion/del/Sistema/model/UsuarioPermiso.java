package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Usuario_Permiso")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UsuarioPermiso {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")
    private Permiso id_permiso;


}
