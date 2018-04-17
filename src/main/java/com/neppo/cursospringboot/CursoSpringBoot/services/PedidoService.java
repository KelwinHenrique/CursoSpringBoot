package com.neppo.cursospringboot.CursoSpringBoot.services;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Pedido;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.PedidoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
