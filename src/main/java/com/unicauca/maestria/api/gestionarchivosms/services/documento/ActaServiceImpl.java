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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
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
        acta.getIdDocMaestria().setLinkDocumento(this.guardarArchivo(acta.getIdDocMaestria().getLinkDocumento()));
        Acta actaDb = actaRepository.save(actaCrearMapper.toEntity(acta));
        return actaListarMapper.toDto(actaDb);
    }

    private String guardarArchivo(String archivoBase64){
        try {
            String[] data = archivoBase64.split("-");
            byte[] archivoByte = Base64.getDecoder().decode(data[1]);
            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yy");
            String fechaFormateada = formatoFecha.format(fechaActual);

            String rutaCarpeta = "./files/" + fechaFormateada;
            String rutaArchivo = rutaCarpeta + "/" + generateUniqueFileName() + "-" + data[0];
            File carpeta = new File(rutaCarpeta);
            OutputStream out = null;
            if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    out = new FileOutputStream(rutaArchivo);
                    out.write(archivoByte);
                    out.close();
                    return rutaArchivo;
                }
            }else{
                out = new FileOutputStream(rutaArchivo);
                out.write(archivoByte);
                out.close();
                return rutaArchivo;
            }
            return "Error al guardar el archivo";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateUniqueFileName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
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
