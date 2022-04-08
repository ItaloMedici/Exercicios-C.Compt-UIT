""" Escreva um programa em Python que print todos os valores únicos do dicionário:
Saída: {'S005', 'S002', 'S007', 'S001', 'S009'}  """

arrDict = [
    {"V": "S001"}, {"V": "S002"}, {"VI": "S001"},
    {"VI": "S005"}, {"VII": "S005"},
    {"V": "S009"}, {"VIII": "S007"}
]

unic = set([v for dt in arrDict for v in dt.values()])
print(unic)