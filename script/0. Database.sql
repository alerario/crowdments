-- ------------------------------------------
-- Software Requistion Tool for Crowdsourcing
-- ------------------------------------------
-- Author: Ricardo Carreiro Alvim
-- WARNING: THIS PROJECT IS CONFIDENTIAL
-- PUBLISH, REDISTRIBUITE OR REUSE OF PART OR ALL 
-- CAN BE 

CREATE DATABASE r4c ENCODING = 'UTF8';
--\c r4c;

CREATE TABLE Project(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120),
    briefing VARCHAR(254),
    dateStarts DATE,
    dateEnds DATE,
    active BOOLEAN
);

CREATE TABLE Questionary(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200),
    dateStart DATE,
    dateEnds DATE,
    briefing VARCHAR(120),
    slug VARCHAR(100),
    active BOOLEAN
);

CREATE TABLE Question(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(200),
    questionary INTEGER,
    CONSTRAINT question_belows_questionary 
    FOREIGN KEY (questionary) REFERENCES Questionary(id)
);

CREATE TABLE Anwser(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    anw VARCHAR(160),
    question INTEGER,
    nextQuestion INTEGER,
    score INTEGER,
    CONSTRAINT anwser_belows_question
    FOREIGN KEY (question) REFERENCES Question(id),

    CONSTRAINT nextQuestion
    FOREIGN KEY (nextQuestion) REFERENCES Question(id)
)

CREATE TABLE TypeProfile(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120),
    active BOOLEAN,
    description VARCHAR(160),
    level INTEGER
);

CREATE TABLE Profile(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(120),
    email VARCHAR(60),
    password VARCHAR(60),
    username VARCHAR(60)
);

CREATE TABLE QuestionaryProfile(
    profile INTEGER,
    questionary INTEGER,
    level INTEGER,

    CONSTRAINT profileAccess
    FOREIGN KEY (profile) REFERENCES Profile(id),

    CONSTRAINT questionaryAllowed
    FOREIGN KEY (questionary) REFERENCES Questionary(id)
);

CREATE TABLE StatsQuestionaryProfile(
    profile INTEGER,
    questionary INTEGER,

);