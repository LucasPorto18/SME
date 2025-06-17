package com.merito.moedaestudantil.dto;
import java.util.List;
import lombok.Data;

@Data
public class InstituicaoDTO {
    private Long id;
    public String nome;
    public String senha;
    public List<ProfessorDTO> professores;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public List<ProfessorDTO> getProfessores() { return professores; }
    public void setProfessores(List<ProfessorDTO> professores) {
        this.professores = professores;
    }
}