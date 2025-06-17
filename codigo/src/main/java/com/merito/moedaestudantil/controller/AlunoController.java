package com.merito.moedaestudantil.controller;
import com.merito.moedaestudantil.dto.AlunoDTO;
import com.merito.moedaestudantil.service.AlunoService;
import com.merito.moedaestudantil.service.InstituicaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;
    private final InstituicaoService instituicaoService;

    public AlunoController(AlunoService alunoService, InstituicaoService instituicaoService) {
        this.alunoService = alunoService;
        this.instituicaoService = instituicaoService;
    }

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aluno", new AlunoDTO());
        model.addAttribute("instituicoes", instituicaoService.buscarTodas());
        return "cadastroaluno";
    }
    

    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute AlunoDTO dto) {
        alunoService.salvar(dto);
        return "redirect:/alunos/cadastro?sucesso";
    }
    
 

    
    
}
