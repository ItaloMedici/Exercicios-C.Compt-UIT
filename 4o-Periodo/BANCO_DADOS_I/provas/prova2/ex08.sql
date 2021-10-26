DELETE
FROM contrato
WHERE data_saida is not null
AND salario < 5000;