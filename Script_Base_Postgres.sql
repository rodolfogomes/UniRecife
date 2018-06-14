


-- -----------------------------------------------------
-- Table departamento
-- -----------------------------------------------------
CREATE TABLE departamento(
  id serial,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(10) ,
  centro VARCHAR(20),
  PRIMARY KEY (id)
  );


-- -----------------------------------------------------
-- Table professor
-- -----------------------------------------------------
CREATE TABLE professor(
  id serial,
  CPF VARCHAR(15)  ,
  nome VARCHAR(45) NOT NULL,
  telefone VARCHAR(15) ,
  salario FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (id)
  );


-- -----------------------------------------------------
-- Table curso
-- -----------------------------------------------------
CREATE TABLE curso (
  id serial,
  descricao VARCHAR(20) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table aluno
-- -----------------------------------------------------
CREATE TABLE aluno (
   id serial,
   matricula INT  NOT NULL unique,
   nome VARCHAR(30) NOT NULL,
   CPF VARCHAR(15) ,
   rua VARCHAR(30) ,
   cidade VARCHAR(20) ,
   CEP VARCHAR(30) ,
   telefone VARCHAR(15) ,
   datanasc DATE ,
   sexo VARCHAR(10) ,
   
  PRIMARY KEY (id));




-- -----------------------------------------------------
-- Table disciplina
-- -----------------------------------------------------
CREATE TABLE disciplina(
  id serial,
  nome VARCHAR(45) NOT NULL,
  descricao VARCHAR(200) NOT NULL
  );




