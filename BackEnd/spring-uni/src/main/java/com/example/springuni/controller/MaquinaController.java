package com.example.springuni.controller;

import com.example.springuni.model.Comando;
import com.example.springuni.model.Maquina;
import com.example.springuni.repository.Maquinas;
import com.example.springuni.service.MaquinaService;
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
public class MaquinaController {

    @Autowired
    MaquinaService maquinaService;

    @Autowired
    Maquinas maquinasRepository;

    //metodo de buscar a maquina por id
    @GetMapping("/{id}")
    public Maquina getMaquinaById(@PathVariable Integer id){
        return maquinasRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Maquina não encontrada"));
    }

    //rota de criar a comando
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Maquina save (@RequestBody Maquina maquinas){
        System.out.println(maquinas);
        return maquinasRepository.save(maquinas);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Maquina> updateMaquina(@PathVariable("id") Integer id, @RequestBody Maquina maquinas) {
        Optional<Maquina> maquinaDados = maquinasRepository.findById(id);

        if (maquinaDados.isPresent()) {
            Maquina _maquinas = maquinaDados.get();
            _maquinas.setId(maquinaDados.get().getId());
            _maquinas.setNomeMaquina(maquinaDados.get().getNomeMaquina());
            _maquinas.setEmail(maquinaDados.get().getEmail());
            _maquinas.setObservacao(maquinaDados.get().getObservacao());
            return new ResponseEntity<>(maquinasRepository.save(_maquinas), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllMaquina() {
        try {
            maquinasRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a estrutura tbm
    @GetMapping
    public List<Maquina> find(Maquina filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return maquinasRepository.findAll(example);
    }
}
