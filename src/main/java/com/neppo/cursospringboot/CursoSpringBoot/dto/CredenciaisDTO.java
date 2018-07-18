package com.neppo.cursospringboot.CursoSpringBoot.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{
    private String email;
    private String senha;

    public CredenciaisDTO(String email, String senha) {
        this.setEmail(email);
        this.setSenha(senha);
    }

    public CredenciaisDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
