package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(unique  = false, length = 100, nullable = false)
    private String nombre;

    @NotBlank(message = "La clave es obligatoria")
    @Column(unique  = false, length = 100, nullable = false)
    private String password;

    @NotBlank(message = "El email es obligatorio")
    @Column(unique  = true, length = 100, nullable = false)
    private String email;

    @Column
    private Integer rol;

    @Column
    private boolean activo;


}
