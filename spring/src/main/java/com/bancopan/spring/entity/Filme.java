package com.bancopan.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Filme {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String id;
    private String nome;
    private Date dataLancamento;
    private String sinopse;
}
