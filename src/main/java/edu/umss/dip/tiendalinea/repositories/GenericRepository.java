package edu.umss.dip.tiendalinea.repositories;

import edu.umss.dip.tiendalinea.model.ModelBase;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("rawtypes")
public interface GenericRepository<T extends ModelBase> extends JpaRepository<T, Long> {

}
