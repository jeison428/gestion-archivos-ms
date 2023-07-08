package com.unicauca.maestria.api.gestionarchivosms.services;

import com.unicauca.maestria.api.gestionarchivosms.domain.DocumentoMaestria;

import java.util.List;

public interface DocumentosService {

    public DocumentoMaestria save(DocumentoMaestria documento);

    public List<DocumentoMaestria> getAll();
}
