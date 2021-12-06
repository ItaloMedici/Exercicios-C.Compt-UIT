/*
  Construa um comando SQL que mostre o CPF dos clientes para os quais existem carros cadastrados, 
  mas não existem orçamentos registrados.
*/

SELECT
  c.cpf
  
FROM CLIENTE c
  INNER JOIN CARRO car ON (car.cliente_cpf = c.cpf) 
  LEFT JOIN ORCAMENTO o ON (o.carro_cod_carro = car.cod_carro)

WHERE
  o.cod_orcamento is null