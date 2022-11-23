package com.example.springuni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="comando")
public class Comando {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "blqBateria")
    private Boolean blqBateria;

    @Column(name = "blqIgnicao")
    private Boolean blqIgnicao;

    @Column(name = "blqInjecaoCombustivel")
    private Boolean blqInjecaoCombustivel;

}
