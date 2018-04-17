package com.neppo.cursospringboot.CursoSpringBoot.repositories;



import com.neppo.cursospringboot.CursoSpringBoot.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{




}
