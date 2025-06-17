package com.merito.moedaestudantil.controller;

import com.merito.moedaestudantil.dto.InstituicaoDTO;
import com.merito.moedaestudantil.dto.ProfessorDTO;
import com.merito.moedaestudantil.service.InstituicaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

    private final InstituicaoService service;

    public InstituicaoController(InstituicaoService service) {
        this.service = service;
    }

    // GET: renderiza o formulário
    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        InstituicaoDTO dto = new InstituicaoDTO();
        dto.professores = new ArrayList<>();
        dto.professores.add(new ProfessorDTO()); // pelo menos 1 professor inicial
        model.addAttribute("instituicao", dto);
        return "cadastroinstituicao"; // nome correto do arquivo HTML
    }

    // POST: salva os dados do formulário
    @PostMapping
    public String salvar(@ModelAttribute("instituicao") InstituicaoDTO dto) {
        service.salvar(dto);
        return "redirect:/instituicoes/cadastro?sucesso"; // redireciona após salvar
    }


}
