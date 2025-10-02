package com.exemplo.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.universidade.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
