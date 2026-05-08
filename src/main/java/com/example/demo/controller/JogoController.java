package com.example.demo.controller;

import com.example.demo.model.Jogo;
import com.example.demo.repository.JogoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository repository;

    @GetMapping
    public List<Jogo> Listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Jogo> BuscarID(@PathVariable Long id){

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Jogo não encontrado"
            );
        }

        return repository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogo Criar(@Valid @RequestBody Jogo jogo){
        return repository.save(jogo);
    }

    @PutMapping("/{id}")
    public Jogo Atualizar(@Valid @RequestBody Jogo jogoAtualizado, @PathVariable Long id){
        return repository.findById(id)
                .map(jogo -> {

                    /*
                    if (
                        jogoAtualizado.getNome() == null || jogoAtualizado.getNome().isBlank() ||
                        jogoAtualizado.getTipo() == null || jogoAtualizado.getTipo().isBlank() ||
                        jogoAtualizado.getNota() == null ||
                        jogoAtualizado.getReview() == null || jogoAtualizado.getReview().isBlank()
                    ){
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                "Todos os campos devem ser preenchidos."
                        );
                    }
                    */


                    jogo.setNome(jogoAtualizado.getNome());
                    jogo.setTipo(jogoAtualizado.getTipo());
                    jogo.setNota(jogoAtualizado.getNota());
                    jogo.setReview(jogoAtualizado.getReview());

                    return repository.save(jogo);
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Jogo não encontrado"
                ));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Jogo não encontrado"
            );
        }

        repository.deleteById(id);
    }




}
