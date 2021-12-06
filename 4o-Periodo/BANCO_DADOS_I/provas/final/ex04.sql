/*
Construa um comando SQL que mostre a quantidade de carros cadastrados por ano de fabricação.
*/

SELECT  
  COUNT(c.cod_carro),
  c.ano_fabricacao
FROM CARRO c
GROUP BY c.ano_fabricacao