package es.santander.ascender.ejerc008.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(max = 80, min = 1)
    @Pattern(regexp = "^\\p{L}+([-' ]\\p{L}+)*$")
    private String nombre;

    @Length(max = 80, min = 1)
    @Pattern(regexp = "^\\p{L}+([-' ]\\p{L}+)*$")
    private String apellidos;

    @NotNull
    @Length(max = 9, min = 8)
    //@Column(unique = true)
    @Pattern(regexp = "^(?:\\d{8}[A-Z]|[XYZ]\\d{7}[A-Z])$")
    private String DNI;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "provincia_id", nullable = true) 
    private Provincia provincia_id;

    @OneToOne(mappedBy = "persona_id", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private Usuario usuario;

    // Overrides de métodos HasCode y equals.

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    // Constructores

    public Persona() {
    }



    
    // Getters y setters


    public Persona( @Length(max = 80, min = 1) String nombre, @Length(max = 80, min = 1) String apellidos,
            @NotNull @Length(max = 9, min = 9) String dNI, Provincia provincia_id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        DNI = dNI;
        this.provincia_id = provincia_id;
    }

    public Provincia getProvincia() {
        return provincia_id;
    }


    public void setProvincia(Provincia provincia_id) {
        this.provincia_id = provincia_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public void setProvincia_id(Provincia provincia_id) {
        this.provincia_id = provincia_id;
    }

    public Provincia getProvincia_id() {
        return provincia_id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    
}
