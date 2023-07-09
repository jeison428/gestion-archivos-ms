package com.unicauca.maestria.api.gestionarchivosms.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OFICIOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Oficio {
    @Id
    @Column(name = "ID_OFICIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOficio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DOC_MAESTRIA")
    private DocumentoMaestria idDocMaestria;

    @Column(name = "NUMOFICIO")
    private String numeroOficio;

    @Column(name = "FECHAOFICIO")
    private Date fechaOficio;

    @Column(name = "ASUNTOOFI")
    private String asuntoOfi;
}
