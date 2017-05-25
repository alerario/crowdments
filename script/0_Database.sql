-- ------------------------------------------
-- Software Requistion Tool for Crowdsourcing
-- ------------------------------------------
-- Author: Ricardo Carreiro Alvim
-- WARNING: THIS PROJECT IS CONFIDENTIAL
-- PUBLISH, REDISTRIBUITE OR REUSE OF PART OR ALL 
-- CAN BE 

CREATE DATABASE r4c ENCODING = 'UTF8';
--\c r4c;
----------------
-- Questionary -
----------------
CREATE TABLE IF NOT EXISTS Questionary (
  id SERIAL PRIMARY KEY,
  name VARCHAR(45) NULL,
  start DATE NULL,
  ends DATE NULL,
  briefing VARCHAR(45) NULL,
  slug VARCHAR(45) NULL,
  active BOOL NULL);

-------------
-- Project --
-------------
CREATE TABLE IF NOT EXISTS Project (
  id SERIAL PRIMARY KEY,
  name VARCHAR(45) NULL,
  briefing VARCHAR(45) NULL,
  starts DATE NULL,
  ends DATE NULL,
  active BOOL NULL,
  questionary INT NOT NULL,
  CONSTRAINT Project_has_Questionary
    FOREIGN KEY (questionary)
    REFERENCES Questionary(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table Question
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Question (
  id SERIAL PRIMARY KEY,
  question VARCHAR(45) NULL,
  questionary INT NOT NULL,
  CONSTRAINT Question_below_questionary
    FOREIGN KEY (questionary)
    REFERENCES Questionary (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table TypeProfile
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TypeProfile (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  active BOOL NOT NULL,
  description VARCHAR(45) NULL,
  level INT NULL,
  PRIMARY KEY (id)
);


-- -----------------------------------------------------
-- Table Profile
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Profile (
  id SERIAL PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  mail VARCHAR(45) NOT NULL,
  password VARCHAR(45) NULL,
  typeProfile INT NOT NULL,
  city VARCHAR(45) NOT NULL,
  state VARCHAR(2) NOT NULL,
  sex VARCHAR(1) NOT NULL,
  studies VARCHAR(45) NOT NULL,
  position VARCHAR(45) NOT NULL,
  CONSTRAINT Profile_has_type
    FOREIGN KEY (typeProfile)
    REFERENCES TypeProfile (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS Anwser (
  id SERIAL PRIMARY KEY,
  anwser VARCHAR(45) NULL,
  score INT NULL 
);

CREATE TABLE AnwserProfileQuestion(
	profile SERIAL,
	question SERIAL,
	anwser SERIAL,

  CONSTRAINT Awnser_has_Question
    FOREIGN KEY (question)
    REFERENCES Question (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT Awnser_has_Profile
    FOREIGN KEY (profile)
    REFERENCES Profile (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT Awnser
    FOREIGN KEY (awnser)
    REFERENCES Anwser(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION    
);

-- -----------------------------------------------------
-- Table QuestionaryProfile
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS QuestionaryProfile (
  level INT NOT NULL,
  profile SERIAL NOT NULL,
  questionary SERIAL NOT NULL,
  CONSTRAINT ToProfile
    FOREIGN KEY (profile)
    REFERENCES Profile (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT ToQuestionary
    FOREIGN KEY (questionary)
    REFERENCES Questionary (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table Statues
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Statues (
  id SERIAL PRIMARY KEY,
  state VARCHAR(45) NOT NULL
);


-- -----------------------------------------------------
-- Table Task
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Task (
  id SERIAL PRIMARY KEY,
  description VARCHAR(45) NOT NULL,
  dueDate DATE NULL,
  statues SERIAL NOT NULL,
  awnser SERIAL NOT NULL,

  CONSTRAINT taskStatues
    FOREIGN KEY (statues)
    REFERENCES Statues (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    
  CONSTRAINT taskswnser
    FOREIGN KEY (awnser)
    REFERENCES Anwser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table Task_has_Project
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Task_has_Project (
  task SERIAL NOT NULL,
  project SERIAL NOT NULL,

  CONSTRAINT task
    FOREIGN KEY (task)
    REFERENCES Task (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

  CONSTRAINT project
    FOREIGN KEY (project)
    REFERENCES Project (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table TagPattern
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS TagPattern (
  id SERIAL PRIMARY KEY,
  description VARCHAR(45) NOT NULL
);


-- -----------------------------------------------------
-- Table Anwser_has_TagPattern
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS Anwser_has_TagPattern (
  anwser INT NOT NULL,
  tagPattern INT NOT NULL,

  CONSTRAINT awnser
    FOREIGN KEY (anwser)
    REFERENCES Anwser (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT tagPattern
    FOREIGN KEY (tagPattern)
    REFERENCES TagPattern (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO public.questionary
	(id, name, start, ends, briefing, slug, active)
VALUES 
	(1, 'Qual o celular?', '2017-05-23', '2017-05-31', 'Qual o celular?', 'qual-celular', true);

INSERT INTO public.question
	(id, question, questionary)
	VALUES (1, 'Como seria o celular ideal para você?', 1);

INSERT INTO public.typeprofile
	(id, name, active, description, level)
VALUES
	(1, 'Admin', true, 'admin', 1),
	(2, 'Crowd', true, 'crowd', 2);

INSERT INTO public.profile
	(id, name, mail, typeprofile, city, state, sex, studies, position)
VALUES
	(1, 'ricardo', 'ricardo', 1, 'Assis', 'SP', 'M', 'Superior', 'Analista');
