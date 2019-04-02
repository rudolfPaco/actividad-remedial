package edu.umss.dip.tiendalinea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.umss.dip.tiendalinea.dto.FotoDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "foto")
public class Foto extends ModelBase<FotoDto> implements Serializable {
    @Lob
    private Byte[] image;

    //muchas fotos pertenecen a un equipo
    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = true)
    @JsonIgnore
    private Equipo equipo;

    public Byte[] getImage() {
        return image;
    }
    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

}
