package edu.umss.dip.tiendalinea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "gasto")
public class Gasto extends ModelBase implements Serializable {
    private String descripcion;
    private double valor;

    //
    @ManyToOne
    @JoinColumn(name = "gasto_id", insertable = true)
    @JsonIgnore
    private Equipo equipo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
