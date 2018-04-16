package com.neppo.cursospringboot.CursoSpringBoot.repositories;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
