package edu.umss.dip.tiendalinea.service;

import edu.umss.dip.tiendalinea.model.Equipo;

import java.io.InputStream;
import java.util.List;

public interface EquipoService extends GenericService<Equipo> {
    void saveImage(Long id, InputStream file);

    void actualizarEstado(Equipo equipo);

    List<String> getCategorias();

    List<Equipo> getEquiposByCategoria(String categoria);
}
