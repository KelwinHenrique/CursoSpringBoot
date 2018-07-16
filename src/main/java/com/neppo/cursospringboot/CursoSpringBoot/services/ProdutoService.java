package com.neppo.cursospringboot.CursoSpringBoot.services;


import com.neppo.cursospringboot.CursoSpringBoot.domain.Categoria;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Pedido;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Produto;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.CategoriaRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.PedidoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.ProdutoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaReository;

    public Produto buscar(Integer id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        List<Categoria> categorias = categoriaReository.findAllById(ids);
        return repo.search(nome, categorias, pageRequest);

    }


}
