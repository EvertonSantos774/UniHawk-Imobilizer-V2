package br.com.api.uhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.uhi.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer> {
    
}
