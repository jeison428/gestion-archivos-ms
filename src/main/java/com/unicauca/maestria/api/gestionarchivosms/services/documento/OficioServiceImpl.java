package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.domain.Oficio;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OficioListarDto;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.FieldErrorException;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.ResourceNotFoundException;
import com.unicauca.maestria.api.gestionarchivosms.mappers.OficioCrearMapper;
import com.unicauca.maestria.api.gestionarchivosms.mappers.OficioListarMapper;
import com.unicauca.maestria.api.gestionarchivosms.respositories.OficioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OficioServiceImpl implements OficioService {

    private final OficioRepository oficioRepository;
    private final OficioCrearMapper oficioCrearMapper;
    private final OficioListarMapper oficioListarMapper;

    @Override
    public OficioListarDto crear(OficioCrearDto oficio, BindingResult result) {
        if (result.hasErrors()) {
            throw new FieldErrorException(result);
        }

        Oficio oficioDb = oficioRepository.save(oficioCrearMapper.toEntity(oficio));

        return oficioListarMapper.toDto(oficioDb);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OficioListarDto> listarTodos() {
        return oficioListarMapper.toDtoList(this.oficioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public OficioListarDto buscarPorId(Long id) {
        return this.oficioRepository.findById(id).map(oficioListarMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Oficio con id: " + id + " No encontrada"));
    }
}
