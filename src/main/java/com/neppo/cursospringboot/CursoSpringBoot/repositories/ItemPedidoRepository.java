package com.neppo.cursospringboot.CursoSpringBoot.repositories;


import com.neppo.cursospringboot.CursoSpringBoot.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{




}
