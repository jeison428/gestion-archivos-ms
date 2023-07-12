package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.domain.DocumentoMaestria;
import com.unicauca.maestria.api.gestionarchivosms.respositories.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Override
    public ResponseEntity<DocumentoMaestria> crear(DocumentoMaestria documento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(documento));
    }

    @Override
    public ResponseEntity<List<DocumentoMaestria>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public ResponseEntity<DocumentoMaestria> buscarPorId(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).orElse(null));
    }

    @Override
    public ResponseEntity<DocumentoMaestria> editarDocumento(Long id, DocumentoMaestria documento) {
        DocumentoMaestria documentoTmp = buscarPorId(id).getBody();
        DocumentoMaestria responseDoc = null;
        if (documentoTmp != null){
            responseDoc = repository.save(documento);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responseDoc);
    }
}
