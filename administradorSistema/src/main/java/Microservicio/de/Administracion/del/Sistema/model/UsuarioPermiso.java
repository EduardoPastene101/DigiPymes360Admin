package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario_Permiso")
@Data

public class UsuarioPermiso {
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_permiso", referencedColumnName = "id_permiso")
    private Permiso id_permiso;

    public UsuarioPermiso() {
    }

    public UsuarioPermiso(Usuario id_usuario, Permiso id_permiso) {
        this.id_usuario = id_usuario;
        this.id_permiso = id_permiso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Permiso getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(Permiso id_permiso) {
        this.id_permiso = id_permiso;
    }
}
