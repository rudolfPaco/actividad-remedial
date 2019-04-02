package edu.umss.dip.tiendalinea.service;

import edu.umss.dip.tiendalinea.model.Equipo;
import edu.umss.dip.tiendalinea.model.Foto;
import edu.umss.dip.tiendalinea.repositories.EquipoRepository;
import edu.umss.dip.tiendalinea.repositories.FotoRepository;
import edu.umss.dip.tiendalinea.repositories.GenericRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class FotoServiceImpl extends GenericServiceImpl<Foto> implements FotoService {

    private FotoRepository fotoRepository;
    private EquipoRepository equipoRepository;

    public FotoServiceImpl(FotoRepository fotoRepository, EquipoRepository equipoRepository) {
        this.fotoRepository = fotoRepository;
        this.equipoRepository = equipoRepository;
    }

    @Override
    protected GenericRepository<Foto> getRepository() {
        return fotoRepository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Foto foto = new Foto();
        Equipo equipo = equipoRepository.getOne(id);
        foto.setEquipo(equipo);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            foto.setImage(bytes);
            getRepository().save(foto);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

    @Override
    public List<Foto> fotosEquipo(long idEquipo) {
        List<Foto> fotos = fotoRepository.findAllByEquipo(idEquipo);
        return fotos;
    }

}
