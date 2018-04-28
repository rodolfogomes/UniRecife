



create database UniRecife;
use UniRecife;

-- -----------------------------------------------------
-- Table departamento
-- -----------------------------------------------------
CREATE TABLE departamento(
  dep_codigo INT identity(1,1) NOT NULL,
  dep_nome VARCHAR(45) NOT NULL,
  dep_telefone VARCHAR(10) NULL DEFAULT NULL,
  dep_centro VARCHAR(20) NOT NULL,
  PRIMARY KEY (dep_codigo)
  );


-- -----------------------------------------------------
-- Table professor
-- -----------------------------------------------------
CREATE TABLE professor(
  professor_CPF VARCHAR(15) NOT NULL,
  professor_nome VARCHAR(45) NOT NULL,
  professor_dep_codigo INT NULL DEFAULT NULL,
  professor_telefone VARCHAR(15) NOT NULL,
  professor_salario FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (professor_CPF),
  CONSTRAINT fk_prof_dep FOREIGN KEY (professor_dep_codigo)
						REFERENCES departamento (dep_codigo));


-- -----------------------------------------------------
-- Table curso
-- -----------------------------------------------------
CREATE TABLE curso (
  curso_codigo INT identity(1,1)NOT NULL,
  curso_tipo VARCHAR(20) NOT NULL,
  curso_cpf_coordenador VARCHAR(15) NULL DEFAULT NULL,
  curso_cpf_vicecoordenador VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (curso_codigo),
  CONSTRAINT fk_curso_prof
    FOREIGN KEY (curso_cpf_coordenador)
    REFERENCES professor (professor_CPF),
  CONSTRAINT fk_curso_vc
    FOREIGN KEY (curso_cpf_vicecoordenador)
    REFERENCES professor (professor_CPF));


-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE aluno (
  aluno_matricula INT identity(1,1) NOT NULL,
  aluno_nome VARCHAR(30) NOT NULL,
  aluno_CPF VARCHAR(15) NOT NULL,
  aluno_rua VARCHAR(30) NOT NULL,
  aluno_cidade VARCHAR(20) NOT NULL,
  aluno_CEP VARCHAR(30) NOT NULL,
  aluno_telefone1 VARCHAR(15) NOT NULL,
  aluno_telefone2 VARCHAR(15) NOT NULL,
  aluno_datanasc DATE NOT NULL,
  aluno_sexo VARCHAR(10) NOT NULL,
  aluno_dep_codigo INT NOT NULL,
  aluno_curso_codigo int NOT NULL,
  PRIMARY KEY (aluno_matricula),
  CONSTRAINT fk_aluno_curso
    FOREIGN KEY (aluno_curso_codigo)
    REFERENCES curso (curso_codigo),
  CONSTRAINT fk_aluno_dep
    FOREIGN KEY (aluno_dep_codigo)
    REFERENCES departamento (dep_codigo));


-- -----------------------------------------------------
-- Table alunoposgrad
-- -----------------------------------------------------
CREATE TABLE alunoposgrad (
  alunoposgrad_matricula INT identity(1,1) NOT NULL,
  alunoposgrad_cpf_orientador VARCHAR(15) NOT NULL,
  alunoposgrad_bolsa FLOAT NOT NULL,
  PRIMARY KEY (alunoposgrad_matricula),
  CONSTRAINT fk_apg_prof
    FOREIGN KEY (alunoposgrad_cpf_orientador)
    REFERENCES professor (professor_CPF));


-- -----------------------------------------------------
-- Table disciplina
-- -----------------------------------------------------
CREATE TABLE disciplina(
  disciplina_codigo_disciplina INT NOT NULL,
  disciplina_nome VARCHAR(45) NOT NULL,
  disciplina_descricao VARCHAR(200) NOT NULL,
  disciplina_dep_codigo INT NOT NULL,
  PRIMARY KEY (disciplina_codigo_disciplina),
  CONSTRAINT fk_disc_dep
    FOREIGN KEY (disciplina_dep_codigo)
    REFERENCES departamento (dep_codigo));


-- -----------------------------------------------------
-- Table oferta
-- -----------------------------------------------------
CREATE TABLE oferta (
  oferta_codigo_oferta INT identity(1,1) NOT NULL,
  oferta_disciplina_codigo INT NOT NULL,
  oferta_professor_cpf VARCHAR(15) NOT NULL,
  oferta_horario TIMESTAMP NOT NULL,
  PRIMARY KEY (oferta_codigo_oferta),
  CONSTRAINT fk_ofert_disc
    FOREIGN KEY (oferta_disciplina_codigo)
    REFERENCES disciplina (disciplina_codigo_disciplina),
  CONSTRAINT fk_oferta_prof
    FOREIGN KEY (oferta_professor_cpf)
    REFERENCES professor (professor_CPF));


-- -----------------------------------------------------
-- Table matricula
-- -----------------------------------------------------
CREATE TABLE matricula (
  matricula_numero INT identity(1,1) NOT NULL,
  matricula_codigo_oferta INT NOT NULL,
  CONSTRAINT fk_mat_oferta
    FOREIGN KEY (matricula_codigo_oferta)
    REFERENCES oferta (oferta_codigo_oferta),
  CONSTRAINT fk_matri_aluno
    FOREIGN KEY (matricula_numero)
    REFERENCES aluno (aluno_matricula));
