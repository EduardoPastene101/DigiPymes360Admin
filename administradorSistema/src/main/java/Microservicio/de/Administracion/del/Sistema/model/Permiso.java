package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Permiso")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_permiso;

    @Column
    private String nombre;

    @Column
    private String descripcion;


}
