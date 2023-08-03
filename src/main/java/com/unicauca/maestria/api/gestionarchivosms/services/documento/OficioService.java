package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioListarDto;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface OficioService {

    public OficioListarDto crear(OficioCrearDto oficio, BindingResult result);
    public List<OficioListarDto> listarTodos();
    public OficioListarDto buscarPorId(Long id);
}
