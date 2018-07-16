package com.neppo.cursospringboot.CursoSpringBoot.services;


import com.neppo.cursospringboot.CursoSpringBoot.domain.ItemPedido;
import com.neppo.cursospringboot.CursoSpringBoot.domain.PagamentoComBoleto;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Pedido;
import com.neppo.cursospringboot.CursoSpringBoot.domain.Produto;
import com.neppo.cursospringboot.CursoSpringBoot.domain.enums.EstadoPagamento;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.ItemPedidoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.PagamentoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.PedidoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.repositories.ProdutoRepository;
import com.neppo.cursospringboot.CursoSpringBoot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setIstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if(obj.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPgamentoComBoleto(pagto, obj.getIstante());
        }
        obj = repo.save(obj);

        pagamentoRepository.save(obj.getPagamento());

        for (ItemPedido ip : obj.getItens()){
            ip.setDesconto(0.0);
            Produto prod = produtoRepository.getOne(ip.getProduto().getId());
            ip.setPreco(prod.getPreco());
            ip.setPedido(obj);
        }

        itemPedidoRepository.saveAll(obj.getItens());

        return obj;





    }
}
