package com.merito.moedaestudantil.controller;
import org.springframework.web.bind.annotation.RestController;

import com.merito.moedaestudantil.model.Professor;
import com.merito.moedaestudantil.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/professor")
public class ProfessorController {


    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/{id}/saldo")
    public ResponseEntity<?> getSaldo(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        if (professor.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("nome", professor.get().getNome());
            response.put("saldo", professor.get().getMoedas());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
        }
    }
}


