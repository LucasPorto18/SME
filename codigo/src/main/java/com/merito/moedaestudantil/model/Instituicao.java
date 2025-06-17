package com.merito.moedaestudantil.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
@Data
@Entity
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;

    @OneToMany(mappedBy = "instituicao", cascade = CascadeType.ALL)
    private List<Professor> professores;

    
}