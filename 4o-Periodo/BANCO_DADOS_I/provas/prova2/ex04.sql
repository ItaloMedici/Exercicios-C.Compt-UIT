/* Inserindo dados */

INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('Atletico', '1980-01-01', 'br', 'mg', 'itauna', 25);
INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('Zero', '1980-01-01', 'br', 'mg', 'itauna', 25);
INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('Palmeras', '1980-01-01', 'br', 'mg', 'itauna', 25);

/* Query */

SELECT
  COUNT(e.id_equipe)
FROM equipe e
WHERE YEAR(e.data_fundacao) = 1980


