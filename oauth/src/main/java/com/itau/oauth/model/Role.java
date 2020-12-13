package com.itau.oauth.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Role implements GrantedAuthority {

    public Role(String nome) {
        this.nome = nome;
    }
    
    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;

    @Override
    public String getAuthority() {
        return  this.nome;
    }
}
