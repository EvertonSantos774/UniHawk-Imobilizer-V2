package com.example.springuni.controller;

import com.example.springuni.model.Comando;
import com.example.springuni.repository.Comandos;
import com.example.springuni.service.ComandoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ComandoController {

    @Autowired
    ComandoService comandoService;

    @Autowired
    Comandos comandosRepository;

    //metodo de buscar a comando por id
    @GetMapping("/{id}")
    public Comando getComandoById(@PathVariable Integer id){
        return comandosRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Comando não encontrada"));
    }

    //rota de criar a comando
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Comando save (@RequestBody Comando comandos){
        System.out.println(comandos);
        return comandosRepository.save(comandos);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Comando> updateComando(@PathVariable("id") Integer id, @RequestBody Comando comandos) {
        Optional<Comando> comandoDados = comandosRepository.findById(id);

        if (comandoDados.isPresent()) {
            Comando _comandos = comandoDados.get();
            _comandos.setId(comandoDados.get().getId());
            _comandos.setBlqBateria(comandoDados.get().getBlqBateria());
            _comandos.setBlqIgnicao(comandoDados.get().getBlqIgnicao());
            _comandos.setBlqInjecaoCombustivel(comandoDados.get().getBlqInjecaoCombustivel());
            return new ResponseEntity<>(comandosRepository.save(_comandos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllComando() {
        try {
            comandosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a estrutura tbm
    @GetMapping
    public List<Comando> find(Comando filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return comandosRepository.findAll(example);
    }



}


