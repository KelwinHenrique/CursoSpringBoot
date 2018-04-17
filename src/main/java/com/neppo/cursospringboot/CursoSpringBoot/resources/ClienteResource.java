package com.neppo.cursospringboot.CursoSpringBoot.resources;

import com.neppo.cursospringboot.CursoSpringBoot.domain.Cliente;
import com.neppo.cursospringboot.CursoSpringBoot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }



}
