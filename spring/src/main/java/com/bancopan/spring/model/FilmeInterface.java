package com.bancopan.spring.model;

import com.bancopan.spring.entity.Filme;

import java.util.List;

public interface FilmeInterface {

    public Filme criarFilme(Filme novo);
    public Filme buscarFilme(String nome);
    public List<Filme> buscarTodos();
    public Filme atualizarFilme(Filme atualizar, String id);
    public void deletarFilme(String id);



}
