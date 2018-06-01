--drop database UniRecife;

--create database UniRecife;
--use UniRecife;

-- -----------------------------------------------------
-- Table departamento
-- -----------------------------------------------------
CREATE TABLE departamento(
  id serial,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(10) NULL DEFAULT NULL,
  centro VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
  );


-- -----------------------------------------------------
-- Table professor
-- -----------------------------------------------------
CREATE TABLE professor(
  id serial,
  CPF VARCHAR(15) NOT NULL unique ,
  nome VARCHAR(45) NOT NULL,
  dep_codigo INT NULL DEFAULT NULL,
  telefone VARCHAR(15) NOT NULL,
  salario FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_prof_dep FOREIGN KEY (dep_codigo)
						REFERENCES departamento (id));


-- -----------------------------------------------------
-- Table curso
-- -----------------------------------------------------
CREATE TABLE curso (
  id serial,
  descricao VARCHAR(20) NOT NULL,
  id_coordenador INT NOT NULL,
  id_vicecoordenador INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_curso_prof
    FOREIGN KEY (id_coordenador)
    REFERENCES professor (id),
  CONSTRAINT fk_curso_vc
    FOREIGN KEY (id_vicecoordenador)
    REFERENCES professor (id));


-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE aluno (
   id serial,
   matricula INT  NOT NULL unique,
   nome VARCHAR(30) NOT NULL,
   CPF VARCHAR(15) NOT NULL,
   rua VARCHAR(30) NOT NULL,
   cidade VARCHAR(20) NOT NULL,
   CEP VARCHAR(30) NOT NULL,
   telefone VARCHAR(15) NOT NULL,
   datanasc DATE NOT NULL,
   sexo VARCHAR(10) NOT NULL,
   id_dept INT NOT NULL,
   id_curso int NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_aluno_curso
    FOREIGN KEY (id_curso)
    REFERENCES curso (id),
  CONSTRAINT fk_aluno_dep
    FOREIGN KEY (id_dept)
    REFERENCES departamento (id));


-- -----------------------------------------------------
-- Table alunoposgrad
-- -----------------------------------------------------
CREATE TABLE alunoposgrad (
   id serial,
   id_orientador INT NOT NULL,
   bolsa decimal(6,2) NOT NULL,
   PRIMARY KEY (id),
   CONSTRAINT fk_apg_prof
     FOREIGN KEY (id_orientador)
	REFERENCES professor(id)	
     );


-- -----------------------------------------------------
-- Table disciplina
-- -----------------------------------------------------
CREATE TABLE disciplina(
  id serial,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(200) NOT NULL,
  id_dept INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_disc_dep
    FOREIGN KEY (id_dept)
    REFERENCES departamento (id));


-- -----------------------------------------------------
-- Table oferta
-- -----------------------------------------------------
CREATE TABLE oferta (
  id serial,
  id_disciplina INT NOT NULL,
  id_professor INT NOT NULL,
  horario TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_ofert_disc
    FOREIGN KEY (id_disciplina)
    REFERENCES disciplina (id),
  CONSTRAINT fk_oferta_prof
    FOREIGN KEY (id_professor)
    REFERENCES professor (id));


-- -----------------------------------------------------
-- Table matricula
-- -----------------------------------------------------
CREATE TABLE matricula (
  id serial,
  id_oferta INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_mat_oferta
    FOREIGN KEY (id_oferta)
    REFERENCES oferta (id));
