package edu.umss.dip.tiendalinea.service;

import edu.umss.dip.tiendalinea.model.Foto;

import java.io.InputStream;
import java.util.List;

public interface FotoService extends GenericService<Foto> {
    void saveImage(Long id, InputStream file);

    List<Foto> fotosEquipo(long idEquipo);
}
