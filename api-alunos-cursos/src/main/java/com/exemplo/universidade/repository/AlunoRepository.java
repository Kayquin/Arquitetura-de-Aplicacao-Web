package com.exemplo.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.universidade.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
