package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario id_usuario;

    @Column
    private String direccion;
    
    @Column
    private String telefono;


}
