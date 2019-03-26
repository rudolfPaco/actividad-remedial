package edu.umss.dip.tiendalinea.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "venta")
public class Venta extends ModelBase implements Serializable {
    private String codigoEquipo;
    private String descripcionEquipo;
    private double precioVenta;
    private String nombreCliente;

    //muchos dotaciones puede tener un empleadoD
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //muchas dotaciones puede realizar un equipo
    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String getDescripcionEquipo() {
        return descripcionEquipo;
    }

    public void setDescripcionEquipo(String descripcionEquipo) {
        this.descripcionEquipo = descripcionEquipo;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
