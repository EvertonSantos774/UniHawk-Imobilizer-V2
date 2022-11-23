package com.example.springuni.controller;

import com.example.springuni.model.Comando;
import com.example.springuni.model.Maquina;
import com.example.springuni.model.Usuario;
import com.example.springuni.repository.Usuarios;
import com.example.springuni.service.UsuarioService;
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
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Usuarios usuariosRepository;

    //metodo de buscar a usuario por id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return usuariosRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Maquina não encontrada"));
    }

    //rota de criar a usuario
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save (@RequestBody Usuario usuarios){
        System.out.println(usuarios);
        return usuariosRepository.save(usuarios);
    }

    @PutMapping("/updateUsers/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuarios) {
        Optional<Usuario> usuarioDados = usuariosRepository.findById(id);

        if (usuarioDados.isPresent()) {
            Usuario _usuarios = usuarioDados.get();
            _usuarios.setId(usuarioDados.get().getId());
            _usuarios.setEmail(usuarioDados.get().getEmail());
            _usuarios.setSenha(usuarioDados.get().getSenha());
            _usuarios.setConfirmarSenha(usuarioDados.get().getConfirmarSenha());
            return new ResponseEntity<>(usuariosRepository.save(_usuarios), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllUsuario() {
        try {
            usuariosRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // pesquisa de usuário, servirá para a usuario tbm
    @GetMapping
    public List<Usuario> find(Usuario filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return usuariosRepository.findAll(example);
    }
}
