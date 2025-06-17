package com.merito.moedaestudantil.repository;
import com.merito.moedaestudantil.model.Aluno;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpfAndSenha(String cpf, String senha);
}
