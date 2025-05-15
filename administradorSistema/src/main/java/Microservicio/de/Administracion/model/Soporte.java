package Microservicio.de.Administracion.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_soporte;

    @JoinColumn(name = "id_cliente")
    private String ic_cliente;

    @Column
    private String mensaje;

    @Column
    private String estado;

    @Column
    private Date fecha;
}
