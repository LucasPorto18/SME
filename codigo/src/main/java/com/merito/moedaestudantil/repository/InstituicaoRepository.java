package com.merito.moedaestudantil.repository;

import com.merito.moedaestudantil.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
}