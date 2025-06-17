package com.merito.moedaestudantil.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;
    private Integer moedas = 0;

    @ManyToOne(fetch = FetchType.LAZY)  
    @JoinColumn(name = "instituicao_id", nullable = false)
    private Instituicao instituicao;

    private String curso;
    private String senha;


}
