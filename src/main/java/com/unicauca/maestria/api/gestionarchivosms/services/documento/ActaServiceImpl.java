package com.unicauca.maestria.api.gestionarchivosms.services.documento;

import com.unicauca.maestria.api.gestionarchivosms.domain.Acta;
import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaCrearDto;
import com.unicauca.maestria.api.gestionarchivosms.dtos.ActaListarDto;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.FieldErrorException;
import com.unicauca.maestria.api.gestionarchivosms.exceptions.ResourceNotFoundException;
import com.unicauca.maestria.api.gestionarchivosms.mappers.ActaCrearMapper;
import com.unicauca.maestria.api.gestionarchivosms.mappers.ActaListarMapper;
import com.unicauca.maestria.api.gestionarchivosms.respositories.ActaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ActaServiceImpl implements ActaService {

    private final ActaRepository actaRepository;
    private final ActaCrearMapper actaCrearMapper;
    private final ActaListarMapper actaListarMapper;

    @Override
    public ActaListarDto crear(ActaCrearDto acta, BindingResult result) {
        if (result.hasErrors()) {
            throw new FieldErrorException(result);
        }
        System.out.println("aca lo guaarado ---- "+acta.getIdDocMaestria().getLinkDocumento());

        Acta actaDb = actaRepository.save(actaCrearMapper.toEntity(acta));
        System.out.println("aca ya deberiaa estar el link real ----- "+actaDb.getIdDocMaestria().getLinkDocumento());

        return actaListarMapper.toDto(actaDb);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActaListarDto> listarTodos() {
        return actaListarMapper.toDtoList(this.actaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ActaListarDto buscarPorId(Long id) {
        return this.actaRepository.findById(id).map(actaListarMapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Acta con id: " + id + " No encontrada"));
    }

    @Override
    public ActaListarDto editarActa(Long id, ActaCrearDto documento, BindingResult result) {
        Acta documentoTmp = actaRepository.findById(id).orElse(null);
        Acta responseDoc = null;
        if (documentoTmp != null){
            //responseDoc = actaRepository.save(documento);
        }
        return null;
    }
}
