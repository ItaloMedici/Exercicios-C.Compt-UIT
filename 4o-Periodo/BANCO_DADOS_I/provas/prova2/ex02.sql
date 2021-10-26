/* Inserindo dados */

INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('B', current_date, 'br', 'mg', 'itauna', 5);
INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('B', current_date, 'br', 'mg', 'itauna', 8);
INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('B', current_date, 'br', 'mg', 'itauna', 50);
INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('B', current_date, 'br', 'mg', 'itauna', 25);

INSERT INTO equipe (nome_equipe, data_fundacao, pais, estado, cidade, quantidade_socios) 
VALUES ('cees', current_date, 'colombia', 'tulipa', 'Belo Horizonte', 5);

/* Query */

SELECT  
  AVG(e.quantidade_socios) AS media_quantidade_socios
FROM equipe e

/* Resultato
  media_quantidade_socios
  22 
*/