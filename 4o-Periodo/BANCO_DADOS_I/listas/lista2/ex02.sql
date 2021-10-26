UPDATE Paciente SET cidade = 'Ilhota' WHERE (codp = 2);

UPDATE Consultas SET data = '2018/05/04', hora= '12:00' WHERE (codm = 1 and codp = 4);

UPDATE Paciente SET doenca = 'cancer' WHERE (codp = 1);

UPDATE Consultas SET hora= '14:30' WHERE (codm = 3 and codp = 4);

DELETE FROM Funcionarios WHERE (codf = 4);

DELETE FROM Consultas WHERE (hora > '19:00');

DELETE FROM Pacientes WHERE (doenca = 'câncer' or idade < 10);

DELETE FROM Medicos WHERE (cidade = 'Biguacu' or cidade = 'Palhoca');