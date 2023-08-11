package com.unicauca.maestria.api.gestionarchivosms.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "OTROS_DOC")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OtroDoc {

    @Id
    @Column(name = "IDOTRO_DOC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOtroDoc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOC_MAESTRIA")
    private DocumentoMaestria idDocMaestria;

    @Column(name = "NOMBREDOCUMENTO")
    private String nombreDocumento;

    @Column(name = "VERSIONDOC")
    private Long versionDoc;

    @Column(name = "DESCRIPCION_DOCUMENTO")
    private String descripcionDocumento;
}
