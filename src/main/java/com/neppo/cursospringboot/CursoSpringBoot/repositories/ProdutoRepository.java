package com.neppo.cursospringboot.CursoSpringBoot.repositories;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
