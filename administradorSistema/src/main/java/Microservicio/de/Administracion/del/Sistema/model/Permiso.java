package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Permiso")
@Data

public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_permiso;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    public Permiso() {
    }

    public Permiso(Integer id_permiso, String nombre, String descripcion) {
        this.id_permiso = id_permiso;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(Integer id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
