CREATE TABLE equipe (
  id_equipe INT PRIMARY KEY AUTO_INCREMENT,
  nome_equipe VARCHAR(100) NOT NULL,
  data_fundacao DATE NOT NULL,
  pais VARCHAR(100),
  estado VARCHAR(100),
  cidade VARCHAR(100),
  quantidade_socios INT 
);

CREATE TABLE contrato (
  data_entrada DATE PRIMARY KEY,
  data_saida DATE,
  salario FLOAT NOT NULL,
  id_equipe INT,
  id_jogador INT
);

CREATE TABLE jogador (
  id_jogador INT PRIMARY KEY AUTO_INCREMENT,
  nome_jogador VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  cpf DECIMAL(13) NOT NULL,
  cidade VARCHAR(100) 
);

ALTER TABLE contrato ADD CONSTRAINT fk_id_equipe FOREIGN KEY (id_equipe) REFERENCES equipe (id_equipe);
ALTER TABLE contrato ADD CONSTRAINT fk_id_jogador FOREIGN KEY (id_jogador) REFERENCES jogador (id_jogador);



