package com.neppo.cursospringboot.CursoSpringBoot.repositories;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
