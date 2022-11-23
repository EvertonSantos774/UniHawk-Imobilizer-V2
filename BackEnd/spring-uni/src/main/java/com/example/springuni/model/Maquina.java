package com.example.springuni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name="maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name = "nomeMaquina", length = 100 )
    private String nomeMaquina;

    @Column(name = "email", length = 100 )
    private String email;

    @Column(name = "observacao", length = 300 )
    private String observacao;

}