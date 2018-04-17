package com.neppo.cursospringboot.CursoSpringBoot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ItemPedido implements Serializable{

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();


    private double desconto;
    private int quantidade;
    private double preco;

    public ItemPedido(){

    }

    public ItemPedido(Pedido pedido, Produto produto, double desconto, int quantidade, double preco) {
        getId().setPedido(pedido);
        getId().setProduto(produto);
        this.setDesconto(desconto);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }


    public  Produto getProduto(){
        return id.getProduto();
    }
    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
