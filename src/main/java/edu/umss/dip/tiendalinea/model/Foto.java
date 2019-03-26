package edu.umss.dip.tiendalinea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "foto")
public class Foto extends ModelBase implements Serializable {
    private String nombre;
    private Byte[] image;

    //muchas fotos pertenecen a un equipo
    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = true)
    @JsonIgnore
    private Equipo equipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
