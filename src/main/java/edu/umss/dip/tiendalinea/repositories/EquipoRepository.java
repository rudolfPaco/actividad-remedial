package edu.umss.dip.tiendalinea.repositories;

import edu.umss.dip.tiendalinea.model.Equipo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipoRepository extends GenericRepository<Equipo> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Equipo SET estado = :estado where id = :equipo_id", nativeQuery = true)
    void updateEstado(@Param("equipo_id") Long equipo_id, @Param("estado") String estado);

    @Query("SELECT DISTINCT categoria FROM Equipo")
    List<String> getCategorias();

    @Query("FROM Equipo WHERE categoria = :categoria")
    List<Equipo> getEquiposByCategoria(@Param("categoria") String categoria);
}
