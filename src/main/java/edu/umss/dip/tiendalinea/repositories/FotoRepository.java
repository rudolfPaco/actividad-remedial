package edu.umss.dip.tiendalinea.repositories;

import edu.umss.dip.tiendalinea.model.Foto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FotoRepository extends GenericRepository<Foto> {
    @Query("FROM Foto f where f.equipo.id = :equipo_id")
    List<Foto> findAllByEquipo(@Param("equipo_id") Long equipo_id);
}
