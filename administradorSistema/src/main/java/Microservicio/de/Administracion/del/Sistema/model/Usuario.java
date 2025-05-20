package Microservicio.de.Administracion.del.Sistema.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@Data

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

    public Usuario(Integer id_usuario, String nombre, String password, String email, Integer rol, boolean activo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.activo = activo;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "La contraseña es obligatoria") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "La contraseña es obligatoria") String password) {
        this.password = password;
    }

    public @NotBlank(message = "El email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es obligatorio") String email) {
        this.email = email;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario() {
    }
}
