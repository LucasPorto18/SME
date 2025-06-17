package com.merito.moedaestudantil.service;
import com.merito.moedaestudantil.repository.AlunoRepository;
import com.merito.moedaestudantil.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    public LoginService(ProfessorRepository professorRepository, AlunoRepository alunoRepository) {
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

     public String login(String cpf, String senha) {
       
        return professorRepository.findByCpfAndSenha(cpf, senha)
            .map(prof -> "redirect:/professor/home")
          
            .orElseGet(() ->
                alunoRepository.findByCpfAndSenha(cpf, senha)
                    .map(al -> "redirect:/aluno/home")
                    
                    .orElseThrow(() -> new RuntimeException("Usuário inválido"))
            );
    }
}

    



