package com.unicauca.maestria.api.gestionarchivosms.respositories;

import com.unicauca.maestria.api.gestionarchivosms.domain.Oficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OficioRepository extends JpaRepository<Oficio, Long> {

    @Query(
            value = "SELECT * " +
                    "FROM OFICIOS O INNER JOIN DOCUMENTO_MAESTRIA DM ON O.ID_DOC_MAESTRIA = DM.ID_DOC_MAESTRIA " +
                    "WHERE DM.ESTADO = :estado",
            nativeQuery = true
    )
    public List<Oficio> findByEstado(@Param("estado") Boolean estado);
}
