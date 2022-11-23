package com.example.springuni.service;

import com.example.springuni.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private Usuarios usuarios;
}
