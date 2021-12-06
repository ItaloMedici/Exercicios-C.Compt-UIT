/*
  Construa um comando SQL que mostre em ordem alfabética 
  o nome dos clientes e o valor total recebido de cada cliente.
*/

SELECT
  SUM(s.val_servico),
  c.nome
  
FROM CLIENTE c
  INNER JOIN CARRO car ON (car.cliente_cpf = c.cpf) 
  INNER JOIN ORCAMENTO o ON (o.carro_cod_carro = car.cod_carro)
  INNER JOIN SERVICO_has_ORCAMENTO so ON (so.orcamento_cod_orcamento = o.cod_orcamento)
  INNER JOIN SERVICO s ON (s.cod_servico = so.servico_cod_servico )

ORDER BY 
  c.nome