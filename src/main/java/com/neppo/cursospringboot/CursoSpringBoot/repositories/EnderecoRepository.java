package com.neppo.cursospringboot.CursoSpringBoot.repositories;



import com.neppo.cursospringboot.CursoSpringBoot.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
