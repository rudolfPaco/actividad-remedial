package edu.umss.dip.tiendalinea.repositories;

import edu.umss.dip.tiendalinea.model.Equipo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EquipoRepository extends GenericRepository<Equipo> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Equipo SET estado = :estado where id = :equipo_id", nativeQuery = true)
    void updateEstado(@Param("equipo_id") Long equipo_id, @Param("estado") String estado);
}
