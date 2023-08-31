package com.unicauca.maestria.api.gestionarchivosms.dtos;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DocumentoMaestriaCrearaDto {

    @NotNull
    private String linkDocumento;
}
