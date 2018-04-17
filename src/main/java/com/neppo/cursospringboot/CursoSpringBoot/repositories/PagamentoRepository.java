package com.neppo.cursospringboot.CursoSpringBoot.repositories;



import com.neppo.cursospringboot.CursoSpringBoot.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{


}
