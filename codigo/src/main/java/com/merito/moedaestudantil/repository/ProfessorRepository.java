package com.merito.moedaestudantil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.merito.moedaestudantil.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByCpfAndSenha(String cpf, String senha);
    Optional<Professor> findById(Long id);
}
