package edu.umss.dip.tiendalinea.service;

import edu.umss.dip.tiendalinea.model.Equipo;
import edu.umss.dip.tiendalinea.repositories.EquipoRepository;
import edu.umss.dip.tiendalinea.repositories.GenericRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class EquipoServiceImpl extends GenericServiceImpl<Equipo> implements EquipoService {

    private EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @Override
    protected GenericRepository<Equipo> getRepository() {
        return equipoRepository;
    }

    @Override
    public void saveImage(Long id, InputStream file) {
        Equipo equipo = findById(id);
        try {
            Byte[] bytes = ImageUtils.inputStreamToByteArray(file);
            equipo.setImage(bytes);
            getRepository().save(equipo);
        } catch (IOException e) {
            logger.error("Error reading file", e);
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEstado(Equipo equipo) {
        equipoRepository.updateEstado(equipo.getId(), equipo.getEstado());
    }
}
