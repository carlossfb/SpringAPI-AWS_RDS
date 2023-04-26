package com.bancopan.spring.service;

import com.bancopan.spring.entity.Filme;
import com.bancopan.spring.model.FilmeInterface;
import com.bancopan.spring.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmeService implements FilmeInterface{

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public Filme criarFilme(Filme novo) {
        String uuid = getUUID();

        novo.setId(uuid);
        novo.setNome(novo.getNome());
        novo.setDataLancamento(novo.getDataLancamento());
        novo.setSinopse(novo.getSinopse());

        filmeRepository.save(novo);
        return novo;
    }

    @Override
    public Filme buscarFilme(String id) {
        Filme busca = filmeRepository.findById(id).get();

        return busca;
    }

    @Override
    public List<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    @Override
    public Filme atualizarFilme(Filme atualizar, String id) {
    Filme filme = filmeRepository.findById(id).get();

    if (atualizar.getNome() != null){
        filme.setNome(atualizar.getNome());
    }
    if (atualizar.getSinopse() != null){
        filme.setSinopse(atualizar.getSinopse());
    }
    if (atualizar.getDataLancamento() != null){
        filme.setDataLancamento(atualizar.getDataLancamento());
    }

    filmeRepository.save(filme);
    return filme;

    }

    @Override
    public void deletarFilme(String id) {
        filmeRepository.deleteById(id);
    }


    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
