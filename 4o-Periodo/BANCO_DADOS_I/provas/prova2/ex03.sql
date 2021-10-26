/* Inserindo dados */

INSERT INTO jogador (nome_jogador, data_nascimento, cpf, cidade) 
VALUES ('Tales', '1990-12-01', 123456789, 'itauna')
INSERT INTO jogador (nome_jogador, data_nascimento, cpf, cidade) 
VALUES ('Tales', '1998-12-01', 789654123, 'itauna')
INSERT INTO jogador (nome_jogador, data_nascimento, cpf, cidade) 
VALUES ('Tales', '1987-01-01', 789456123, 'itauna')
INSERT INTO jogador (nome_jogador, data_nascimento, cpf, cidade) 
VALUES ('Tales', '1987-01-01', 789456123, 'itauna')
INSERT INTO jogador (nome_jogador, data_nascimento, cpf, cidade) 
VALUES ('Julio', '1990-01-01', 789456123, 'itauna')

/* Query */

SELECT
  j.nome_jogador
FROM jogador j
WHERE YEAR(j.data_nascimento) BETWEEN 1990 AND 1999
