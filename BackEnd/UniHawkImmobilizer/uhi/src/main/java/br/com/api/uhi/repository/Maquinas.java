package br.com.api.uhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.uhi.model.Maquina;

public interface Maquinas extends JpaRepository<Maquina, Integer> {
    
}
