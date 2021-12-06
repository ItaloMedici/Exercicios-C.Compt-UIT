/*
  Construa um comando SQL que mostre os orçamentos com valor total superior a R$3.000,00.
*/

SELECT
  o.cod_orcamento,
  o.dat_orcamento,

FROM ORCAMENTO o
  INNER JOIN SERVICO_has_ORCAMENTO so ON (so.orcamento_cod_orcamento = o.cod_orcamento)
  INNER JOIN SERVICO s ON (s.cod_servico = so.servico_cod_servico )

WHERE
  s.val_servico > 3000

