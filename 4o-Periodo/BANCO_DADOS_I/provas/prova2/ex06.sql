SELECT  
  SUM(c.salario) AS soma_salario
FROM contrato c
WHERE 
  c.data_saida is null
  AND c.id_equipe = 4