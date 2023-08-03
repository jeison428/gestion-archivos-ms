package com.unicauca.maestria.api.gestionarchivosms.respositories;

import com.unicauca.maestria.api.gestionarchivosms.domain.Acta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActaRepository extends JpaRepository<Acta, Long> {
}
