package com.merito.moedaestudantil.model;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String departamento;
    private String senha;
    private Integer moedas = 0;

    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    private Instituicao instituicao;

    
}