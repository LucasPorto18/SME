package com.merito.moedaestudantil.dto;


import lombok.Data;

@Data
public class AlunoDTO {
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;
    private Long instituicaoId;  
    private String curso;
    private String senha;
    private Integer moedas = 0;
}
