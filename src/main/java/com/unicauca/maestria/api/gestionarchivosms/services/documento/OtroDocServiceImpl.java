package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.domain.OtroDoc;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OtroDocCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.OtroDocListarDto;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.FieldErrorException;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.ResourceNotFoundException;
import com.unicauca.maestria.api.gestionarchivosms.mappers.OtroDocCrearMapper;
import com.unicauca.maestria.api.gestionarchivosms.mappers.OtroDocListarMapper;
import com.unicauca.maestria.api.gestionarchivosms.respositories.OtroDocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OtroDocServiceImpl implements OtroDocService{

    private final OtroDocRepository otroDocRepository;
    private final OtroDocCrearMapper otroDocCrearMapper;
    private final OtroDocListarMapper otroDocListarMapper;

    @Override
    public OtroDocListarDto crear(OtroDocCrearDto otroDoc, BindingResult result) {
        if (result.hasErrors()) {
            throw new FieldErrorException(result);
        }

        OtroDoc otroDocDb = otroDocRepository.save(otroDocCrearMapper.toEntity(otroDoc));

        return otroDocListarMapper.toDto(otroDocDb);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OtroDocListarDto> listarTodos() {
        return otroDocListarMapper.toDtoList(this.otroDocRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public OtroDocListarDto buscarPorId(Long id) {
        return this.otroDocRepository.findById(id).map(otroDocListarMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("OtroDoc con id: " + id + " No encontrada"));
    }
}
