package com.bancopan.spring.controller;

import com.bancopan.spring.entity.Filme;
import com.bancopan.spring.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/all")
    public ResponseEntity<List<Filme>> buscarTodos() {
        List<Filme> response = filmeService
                .buscarTodos();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilme(@PathVariable("id") String id) {
        Filme response = filmeService.buscarFilme(id);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable("id") String id, @RequestBody Filme atualizar) {

        Filme response = filmeService.atualizarFilme(atualizar, id);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/new")
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme novo) {
        novo = filmeService.criarFilme(novo);

        return ResponseEntity.status(HttpStatus.CREATED).body(novo);

    }
    @DeleteMapping("/delete/{id}")
    public String deletarFilme(@PathVariable("id") String id){
        filmeService.deletarFilme(id);
        return "Deletamos o id = " + id;
    }

}
