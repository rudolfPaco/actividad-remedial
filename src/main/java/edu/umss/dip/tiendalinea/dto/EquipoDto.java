package edu.umss.dip.tiendalinea.dto;

import edu.umss.dip.tiendalinea.model.Equipo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;

public class EquipoDto extends DtoBase<Equipo> {
    private String codigo;
    private String categoria;
    private String marca;
    private String modelo;
    private String capacidad;
    private double precio;
    private double costoTotal;
    private String estado;
    private String image;
    private String urlVideo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public EquipoDto toDto(Equipo equipo, ModelMapper mapper) {
        super.toDto(equipo, mapper);
        if (equipo.getImage() != null) {
            byte[] bytes = new byte[equipo.getImage().length];
            for (int i = 0; i < equipo.getImage().length; i++) {
                bytes[i] = equipo.getImage()[i];
            }
            String imageStr = Base64.encodeBase64String(bytes);
            setImage(imageStr);
        }
        return this;
    }
}
