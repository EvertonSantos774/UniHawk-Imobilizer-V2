package br.com.api.uhi.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @OneToMany(mappedBy = "usuario")
    private Set<Maquina> maquina;
}