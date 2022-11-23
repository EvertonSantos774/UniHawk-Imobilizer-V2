package com.example.springuni.service;

import com.example.springuni.repository.Maquinas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinaService {
    @Autowired
    private Maquinas maquinas;
}
