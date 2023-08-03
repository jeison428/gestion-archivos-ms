package com.unicauca.maestria.api.gestionarchivosms.dtos;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentoMaestriaCrearaDto {

    @NotNull
    @Size(min = 5)
    private String linkDocumento;
}
