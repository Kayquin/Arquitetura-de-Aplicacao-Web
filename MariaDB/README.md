# 📚 Banco de Dados Relacional - Cadastro de Alunos

Este projeto tem como objetivo a criação e manipulação de um **banco de dados relacional** para cadastro de alunos em uma instituição de ensino, utilizando **MariaDB** no ambiente **XAMPP**.

## 🛠️ Tecnologias
- XAMPP
- MariaDB
- phpMyAdmin

## 🎯 Objetivos
- Criar o banco de dados `escola`
- Criar a tabela `alunos`
- Inserir registros de alunos
- Realizar consultas, atualizações e exclusões de dados

## 📂 Estrutura da Tabela

```sql
CREATE TABLE alunos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    email VARCHAR(100),
    data_nascimento DATE,
    curso VARCHAR(50),
    ativo BOOLEAN
);
