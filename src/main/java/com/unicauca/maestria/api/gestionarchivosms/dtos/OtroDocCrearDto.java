package com.unicauca.maestria.api.gestionarchivosms.dtos;

import com.unicauca.maestria.api.gestionarchivosms.domain.DocumentoMaestria;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OtroDocCrearDto {

    @NotNull
    @Valid
    private DocumentoMaestria idDocMaestria;

    @NotNull
    @Size(min = 10)
    private String nombreDocumento;

    @NotNull
    @Positive
    private Long versionDoc;

    @NotNull
    @Size(min = 10)
    private String descripcionDocumento;
}
