/*
  Construa uma função que recebe como parâmetro o CPF de um cliente e retorna 1 (um), 
  caso este cliente possua carros cadastrados na oficina e 0 (zero) caso contrário.
*/
CREATE FUNCTION possui_carro_cadastrado (cpf_cliente integer)
  RETURNS integer

BEGIN
  DECLARE has_car integer;
  
  SET has_car = (
    SELECT COUNT(car.cod_carro)
    FROM CLIENTE c
    INNER JOIN CARRO car ON (car.cliente_cpf = c.cpf) 
    WHERE c.cpf = :cpf_cliente
  )

  IF (has_car > 0) THEN 
    RETURNS 1
  ELSE 
    RETURNS 0

END
