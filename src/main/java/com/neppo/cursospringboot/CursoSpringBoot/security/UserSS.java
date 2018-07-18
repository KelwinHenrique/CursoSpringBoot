package com.neppo.cursospringboot.CursoSpringBoot.security;

import com.neppo.cursospringboot.CursoSpringBoot.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSS implements UserDetails{


    private Integer id;
    private String senha;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS(){

    }

    public UserSS(Integer id, String senha, String email, Set<Perfil> perfils) {
        this.id = id;
        this.senha = senha;
        this.email = email;


        this.authorities = perfils.stream().map(x-> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
