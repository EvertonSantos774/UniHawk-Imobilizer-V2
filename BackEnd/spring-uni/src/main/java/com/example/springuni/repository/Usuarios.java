package com.example.springuni.repository;

import com.example.springuni.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Integer> {

}
