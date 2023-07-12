package com.unicauca.maestria.api.gestionarchivosms.controllers;

import com.unicauca.maestria.api.gestionarchivosms.domain.DocumentoMaestria;
import com.unicauca.maestria.api.gestionarchivosms.services.documento.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    public ResponseEntity<DocumentoMaestria> crear(DocumentoMaestria documento){
        return service.crear(documento);
    }

    public ResponseEntity<List<DocumentoMaestria>> listarTodos(){
        return service.listarTodos();
    }

    public ResponseEntity<DocumentoMaestria> buscarPorId(Long id){
        return service.buscarPorId(id);
    }

    public ResponseEntity<DocumentoMaestria> editarDocumento(Long id, DocumentoMaestria documento){
        return service.editarDocumento(id, documento);
    }
}
