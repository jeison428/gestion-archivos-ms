package com.unicauca.maestria.api.gestionarchivosms.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENTO_MAESTRIA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentoMaestria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    @Column(name = "LINK_DOCUMENTO")
    private String linkDocumento;

    @Column(name = "LINK_SOPORTE")
    private String linkSoporte;

}
