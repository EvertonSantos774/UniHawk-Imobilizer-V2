package br.com.api.uhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.uhi.model.Comando;

public interface Comandos extends JpaRepository<Comando, Integer>{
    
}
