package com.example.demo.controller;

import com.example.demo.model.Jogo;
import com.example.demo.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return repository.findById(id);
    }

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo){
        return repository.save(jogo);
    }

    @PutMapping("/{id}")
    public Jogo atualizar(@RequestBody Jogo jogoAtualizado, @PathVariable Long id){
        return repository.findById(id)
                .map(jogo -> {
                    jogo.setNome(jogoAtualizado.getNome());
                    jogo.setEstudio(jogoAtualizado.getEstudio());
                    jogo.setGenero(jogoAtualizado.getGenero());
                    jogo.setAnoPublicacao(jogoAtualizado.getAnoPublicacao());

                    return repository.save(jogo);
                })
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }




}
