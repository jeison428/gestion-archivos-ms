package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.domain.Acta;
import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaListarDto;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ActaService {

    public ActaListarDto crear(ActaCrearDto acta, BindingResult result);

    public List<ActaListarDto> listarTodos();

    public ActaListarDto buscarPorId(Long id);

    public ActaListarDto editarActa(Long id, ActaCrearDto acta, BindingResult result);

}
