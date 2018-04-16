package com.neppo.cursospringboot.CursoSpringBoot.repositories;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
