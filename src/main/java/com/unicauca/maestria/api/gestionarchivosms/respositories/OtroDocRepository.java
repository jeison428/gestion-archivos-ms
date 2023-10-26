package com.unicauca.maestria.api.gestionarchivosms.respositories;

import com.unicauca.maestria.api.gestionarchivosms.domain.OtroDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtroDocRepository extends JpaRepository<OtroDoc, Long> {
    @Query(
            value = "SELECT * " +
                    "FROM OTROS_DOC OD INNER JOIN DOCUMENTO_MAESTRIA DM ON OD.ID_DOC_MAESTRIA = DM.ID_DOC_MAESTRIA " +
                    "WHERE DM.ESTADO = :estado",
            nativeQuery = true
    )
    public List<OtroDoc> findByEstado(@Param("estado") Boolean estado);

    public List<OtroDoc> findByNombreDocumentoContainingIgnoreCase(String nombreDocumento);
}
