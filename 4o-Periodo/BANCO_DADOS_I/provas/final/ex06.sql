/*
  Construa um comando SQL que mostre a placa de todos os carros e caso existam 
  orçamentos cadastrados para o carro, mostrar também o número do orçamento (cod_orçamento).
*/


SELECT
  car.placa,
  o.cod_orçamento
  
FROM CARRO car
  LEFT JOIN ORCAMENTO o ON (o.carro_cod_carro = car.cod_carro)