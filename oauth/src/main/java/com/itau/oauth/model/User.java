package com.itau.oauth.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String user;
    
    @JsonIgnore
    private String password;

    private String nome;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",
        joinColumns=@JoinColumn(name="user_id"),
        inverseJoinColumns=@JoinColumn(name="role_id")
    )
    
    private List<Role> roles;

    public User() {
    }

    public User(String user, String nome) {
        super();
        this.user = user;
        this.nome = nome;
    }
    public User(User user) {
        super();
        this.user = user.getUser();
        this.nome = user.getNome();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.id = user.getId();
    }
    public User(String nome, String user, String password, List<Role> roles) {
        super();
        this.nome = nome;
        this.user = user;
        this.roles = roles;
        this.password = password;
    }

}
