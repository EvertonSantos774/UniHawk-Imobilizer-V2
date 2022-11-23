package com.example.springuni.model;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", length = 100 )
    private String email;

    @Column(name = "senha", length = 10 )
    private String senha;

    @Column(name = "confirmarSenha", length = 10 )
    private String confirmarSenha;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private Maquina maquina;
}
