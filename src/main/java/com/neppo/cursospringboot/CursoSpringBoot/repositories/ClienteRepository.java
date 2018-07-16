package com.neppo.cursospringboot.CursoSpringBoot.repositories;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    @Transactional(readOnly = true)
    Cliente findByEmail(String email);
}
