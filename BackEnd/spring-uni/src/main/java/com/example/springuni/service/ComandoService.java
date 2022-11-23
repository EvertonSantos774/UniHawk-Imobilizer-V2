package com.example.springuni.service;

import com.example.springuni.repository.Comandos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComandoService {
    @Autowired
    private Comandos comandos;
}
