package edu.umss.dip.tiendalinea.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "cliente")
public class Cliente extends ModelBase implements Serializable {
    private String nombre;
    private String carnet;
    private int numeroContacto;
    private String email;

    //un cliente tiene una direccion
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Direccion direccion;

    //un cliente puede realizar muchas consultas
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

    //un cliente puede realizar muchas ventas
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(int numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
