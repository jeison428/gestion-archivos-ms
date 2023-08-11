package com.unicauca.maestria.api.gestionarchivosms.respositories;

import com.unicauca.maestria.api.gestionarchivosms.domain.Acta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActaRepository extends JpaRepository<Acta, Long> {

    @Query(
            value = "SELECT * " +
                    "FROM ACTAS A INNER JOIN DOCUMENTO_MAESTRIA DM ON A.ID_DOC_MAESTRIA = DM.ID_DOC_MAESTRIA " +
                    "WHERE DM.ESTADO = :estado",
            nativeQuery = true
    )
    public List<Acta> findByEstado(@Param("estado") Boolean estado);
}
