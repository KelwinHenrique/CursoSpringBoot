package com.neppo.cursospringboot.CursoSpringBoot.services;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Cliente;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.ClienteRepository;
import com.neppo.cursospringboot.CursoSpringBoot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
