package com.bancopan.spring.repository;

import com.bancopan.spring.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, String> {
}
