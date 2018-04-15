package com.neppo.cursospringboot.CursoSpringBoot.repositories;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{




}
