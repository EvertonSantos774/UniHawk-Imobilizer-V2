package com.example.springuni.repository;

import com.example.springuni.model.Comando;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface Comandos extends JpaRepository<Comando, Integer>{

    //@Query(value = "select * from comando where ")
}
