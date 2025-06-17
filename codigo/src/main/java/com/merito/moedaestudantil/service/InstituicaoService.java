package com.merito.moedaestudantil.service;

import com.merito.moedaestudantil.dto.InstituicaoDTO;
import com.merito.moedaestudantil.dto.ProfessorDTO;
import com.merito.moedaestudantil.model.Instituicao;
import com.merito.moedaestudantil.model.Professor;
import com.merito.moedaestudantil.repository.InstituicaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstituicaoService {

    private final InstituicaoRepository repository;

    public InstituicaoService(InstituicaoRepository repository) {
        this.repository = repository;
    }

    public Instituicao salvar(InstituicaoDTO dto) {
        Instituicao inst = new Instituicao();
        inst.setNome(dto.nome);
        inst.setSenha(dto.senha);

        List<Professor> professores = new ArrayList<>();
        for (ProfessorDTO p : dto.professores) {
            Professor prof = new Professor();
            prof.setNome(p.nome);
            prof.setCpf(p.cpf);
            prof.setDepartamento(p.departamento);
            prof.setSenha(p.getSenha());
            prof.setInstituicao(inst);
            professores.add(prof);
        }
        inst.setProfessores(professores);
        return repository.save(inst);
    }

    public List<InstituicaoDTO> buscarTodas() {
        return repository.findAll().stream()
            .map(inst -> {
                InstituicaoDTO dto = new InstituicaoDTO();
                dto.setId(inst.getId());
                dto.nome = inst.getNome();
                dto.senha = inst.getSenha();
                return dto;
            })
            .collect(Collectors.toList());
    }
}