data_entrada, data_saida, salario, id_equipe, id_jogador

INSERT INTO contrato (data_entrada, data_saida, salario, id_equipe, id_jogador) 
VALUES ('2010-01-01', '2010-01-01', 500.00, 1, 1);
INSERT INTO contrato (data_entrada, data_saida, salario, id_equipe, id_jogador) 
VALUES ('2011-01-01', '2012-01-01', 600.00, 1, 2);
INSERT INTO contrato (data_entrada, data_saida, salario, id_equipe, id_jogador) 
VALUES ('2013-01-01', '2014-01-01', 700.00, 1, 3);
INSERT INTO contrato (data_entrada, data_saida, salario, id_equipe, id_jogador) 
VALUES ('2017-01-01', '2018-01-01', 800.00, 1, 4);
INSERT INTO contrato (data_entrada, data_saida, salario, id_equipe, id_jogador) 
VALUES ('2015-01-01', '2019-01-01', 900.00, 1, 5);

SELECT
  MAX(c.salario) as maior_salario
FROM contrato c
WHERE c.data_entrada >= '2015-01-01'
