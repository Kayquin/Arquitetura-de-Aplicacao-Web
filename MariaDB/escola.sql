-- ============================================================
-- Banco de Dados: escola
-- Autor: Kayque Avelar
-- Descrição: Cadastro de alunos em uma instituição de ensino
-- ============================================================

-- 🔹 Criação do banco de dados
CREATE DATABASE IF NOT EXISTS escola;
USE escola;

-- 🔹 Criação da tabela alunos
CREATE TABLE IF NOT EXISTS alunos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    curso VARCHAR(50) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

-- 🔹 Inserção de 5 alunos
INSERT INTO alunos (nome, email, data_nascimento, curso, ativo) VALUES
('Ana Silva', 'ana@email.com', '2000-05-10', 'Engenharia', TRUE),
('Carlos Souza', 'carlos@email.com', '1999-09-23', 'Direito', FALSE),
('Mariana Costa', 'mariana@email.com', '2001-03-14', 'Administração', TRUE),
('João Pereira', 'joao@email.com', '1998-12-02', 'Medicina', TRUE),
('Beatriz Lima', 'bia@email.com', '2002-07-30', 'Engenharia', TRUE);

-- ============================================================
-- 🔎 Consultas
-- ============================================================

-- Listar todos os alunos
SELECT * FROM alunos;

-- Listar apenas alunos ativos
SELECT * FROM alunos WHERE ativo = TRUE;

-- Buscar alunos por curso (exemplo: Engenharia)
SELECT * FROM alunos WHERE curso = 'Engenharia';

-- Ordenar alunos por nome
SELECT * FROM alunos ORDER BY nome ASC;

-- ============================================================
-- ✏️ Atualização
-- ============================================================

-- Alterar o curso de um aluno específico (exemplo: aluno com id 2)
UPDATE alunos SET curso = 'Ciência da Computação' WHERE id = 2;

-- ============================================================
-- 🗑️ Exclusão
-- ============================================================

-- Remover um aluno pelo ID (exemplo: id = 5)
DELETE FROM alunos WHERE id = 5;
