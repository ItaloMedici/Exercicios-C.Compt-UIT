CREATE dataBASE clinica;
USE clinica;

CREATE TABLE Medicos(
codm int,
nome varchar(40) NOT NULL,
idade smallint NOT NULL,
especialidade char(20),
CPF numeric(11) UNIQUE,
cidade varchar(30),
nroa int,
PRIMARY KEY(codm),
FOREIGN KEY(nroa) REFERENCES Ambulatorios(nroa)
);

CREATE TABLE Ambulatorios (
nroa int,
andar numeric(3) NOT NULL,
capacidade smallint,
PRIMARY KEY(nroa)
);

CREATE TABLE Consultas (
codm int,
codp int,
data date,
hora time,
PRIMARY KEY(codm, data , hora),
FOREIGN KEY(codp) REFERENCES Paciente(codp),
FOREIGN KEY(codm) REFERENCES Medicos(codm)
);

CREATE TABLE Paciente(
codp int,
nome varchar(40) NOT NULL,
idade smallint NOT NULL,
cidade char(30),
CPF numeric(11) UNIQUE,
doenca varchar(40) NOT NULL,
PRIMARY KEY(codp)
);


CREATE TABLE Funcionarios(
codf int,
nome varchar(40) NOT NULL,
idade smallint NOT NULL,
cidade char(30),
CPF numeric(11) UNIQUE,
salario numeric(10),
cargo varchar(20),
PRIMARY KEY(codf)
);

ALTER TABLE Funcionarios
ADD nroa int;

CREATE UNIQUE INDEX indMed_CPF ON Medicos (CPF);
CREATE UNIQUE INDEX indPac_Doenca ON Paciente (doenca);

DROP INDEX indPac_Doenca ON Paciente;

ALTER TABLE Funcionarios DROP COLUMN cargo,
DROP COLUMN nroa;

INSERT INTO Ambulatorios VALUES (1, 1, 30);
INSERT INTO Ambulatorios VALUES (2, 1, 50);
INSERT INTO Ambulatorios VALUES (3, 2, 40);
INSERT INTO Ambulatorios VALUES (4, 2, 25);
INSERT INTO Ambulatorios VALUES (5, 2, 55);

INSERT INTO Medicos
(codm, nome, idade, especialidade, CPF, cidade, nroa)
VALUES (1, 'Joao', 40,'ortopedia',10000100000, 'Florianopolis', 1);
INSERT INTO Medicos
(codm, nome, idade, especialidade, CPF, cidade, nroa)
VALUES (2, 'Maria', 42,'traumatologia',10000110001, 'Blumenau', 2);
INSERT INTO Medicos
(codm, nome, idade, especialidade, CPF, cidade, nroa)
VALUES (3, 'Pedro', 51,'Pediatria',10000110002, 'SaoJose', 3);
INSERT INTO Medicos
(codm, nome, idade, especialidade, CPF, cidade)
VALUES (4, 'Carlos', 28,'ortopedia',11000110003, 'Joinville');
INSERT INTO Medicos
(codm, nome, idade, especialidade, CPF, cidade, nroa)
VALUES (5, 'Marcia', 33,'Neurologia',11000111005, 'Biguacu', 5);

INSERT INTO Paciente
(codp, nome, idade, cidade, CPF, doenca)
VALUES (1, 'Ana', 20,'Florianopolis',20000200000, 'Gripe');
INSERT INTO Paciente
(codp, nome, idade, cidade, CPF, doenca)
VALUES (2, 'Paulo', 24,'Palhoça',20000220000, 'Fratura');
INSERT INTO Paciente
(codp, nome, idade, cidade, CPF, doenca)
VALUES (3, 'Lucia', 30,'Biguacu',22000200000, 'Tendinite');
INSERT INTO Paciente
(codp, nome, idade, cidade, CPF, doenca)
VALUES (4, 'Carlos', 28,'Joinville',11000110000, 'sarampo');

INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (1, 1, '2018/06/12', '14:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (1, 4, '2018/06/13', '10:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (2, 1, '2018/06/13', '9:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (2, 2, '2018/06/13', '11:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (2, 3, '2018/06/14', '14:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (2, 4, '2018/06/14', '17:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (3, 1, '2018/06/19', '18:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (3, 3, '2018/06/12', '10:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (3, 4, '2018/06/19', '13:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (4, 4, '2018/06/20', '13:00');
INSERT INTO Consultas 
(codm, codp, data , hora)
VALUES (4, 4, '2018/06/22', '19:30');

INSERT INTO Funcionarios
(codf, Nome, idade , Cidade, salario, CPF)
VALUES (1, 'Rita', 32, 'Sao Jose' , 1200, 20000100000);
INSERT INTO Funcionarios
(codf, Nome, idade , Cidade, salario, CPF)
VALUES (2, 'Maria', 55, 'Palhoça ' , 1220, 30000110000);
INSERT INTO Funcionarios
(codf, Nome, idade , Cidade, salario, CPF)
VALUES (3, 'Caio', 45, 'Florianopolis' , 1100, 41000100000);
INSERT INTO Funcionarios
(codf, Nome, idade , Cidade, salario, CPF)
VALUES (4, 'Carlos', 44, 'Florianopolis' , 1200, 51000110000);
INSERT INTO Funcionarios
(codf, Nome, idade , Cidade, salario, CPF)
VALUES (5, 'Paula', 33, 'Florianopolis' , 2500, 61000111000);