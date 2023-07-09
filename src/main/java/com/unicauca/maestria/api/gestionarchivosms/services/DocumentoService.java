package com.unicauca.maestria.api.gestionarchivosms.services;

import com.unicauca.maestria.api.gestionarchivosms.domain.DocumentoMaestria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DocumentoService {

    public ResponseEntity<DocumentoMaestria> crear(DocumentoMaestria documento);

    public ResponseEntity<List<DocumentoMaestria>> listarTodos();

    public ResponseEntity<DocumentoMaestria> buscarPorId(Long id);

    public ResponseEntity<DocumentoMaestria> editarDocumento(Long id, DocumentoMaestria documento);

}
