/*
 Construa um comando SQL que mostre em ordem alfabética o nome
 dos clientes e a placa dos carros que tiveram orçamentos emitidos em março de 2012.
 */

SELECT
  c.nome,
  car.placa
FROM CLIENTE c
  INNER JOIN CARRO car ON (car.cliente_cpf = c.cpf) 
  INNER JOIN ORCAMENTO o ON (o.carro_cod_carro = car.cod_carro)
WHERE
  o.dat_orcamento BETWEEN '2012-03-01' AND '2012-03-31' 
ORDER BY
  c.nome