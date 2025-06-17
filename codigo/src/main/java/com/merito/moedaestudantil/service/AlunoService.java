package com.merito.moedaestudantil.service;

import com.merito.moedaestudantil.dto.AlunoDTO;
import com.merito.moedaestudantil.model.Aluno;
import com.merito.moedaestudantil.model.Instituicao;
import com.merito.moedaestudantil.repository.AlunoRepository;
import com.merito.moedaestudantil.repository.InstituicaoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final InstituicaoRepository instituicaoRepository;

    public AlunoService(AlunoRepository alunoRepository, InstituicaoRepository instituicaoRepository) {
        this.alunoRepository = alunoRepository;
        this.instituicaoRepository = instituicaoRepository;
    }
    
    public Aluno salvar(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setRg(dto.getRg());
        aluno.setEndereco(dto.getEndereco());
        aluno.setCurso(dto.getCurso());
        Instituicao instituicao = instituicaoRepository.findById(dto.getInstituicaoId())
            .orElseThrow(() -> new RuntimeException("Instituição não encontrada"));
        aluno.setInstituicao(instituicao);
        aluno.setSenha(dto.getSenha());
        return alunoRepository.save(aluno);
    }
    
    
    
}
