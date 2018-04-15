package com.neppo.cursospringboot.CursoSpringBoot.domain;


import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable{//Serializable para que a classe consiga ser tranformada em bytes e ser transmitida por rede
    private Integer id;
    private String nome;

    public  Categoria(){

    }

    public Categoria(Integer id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
