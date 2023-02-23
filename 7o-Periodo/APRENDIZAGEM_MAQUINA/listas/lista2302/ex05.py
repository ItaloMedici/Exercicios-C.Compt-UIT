"""
5) Crie um dicionário com 5 registros, onde o nome é a chave e a idade é o valor;
    Mateus = 25
    Fernanda = 22
    Tamires = 26
    Cristiano = 25
  a) Print todo o dicionário
  b) Print a idade do Mateus;
  c) Adicione a chave Pedro com idade 27
  d) Print a idade de Pedro
  e) Apague o registro Tamires
  f) Print o tamanho do dicionário
"""

regs = {
  "Mateus": 25,
  "Fernanda": 22,
  "Tamires": 26,
  "Cristiano": 25,
}

# a) Print todo o dicionário
print(regs)

# b) Print a idade do Mateus;
print(regs["Mateus"])

# c) Adicione a chave Pedro com idade 27
regs.update({ "Pedro": 27 })

# d) Print a idade de Pedro
print(regs["Pedro"])

# e) Apague o registro Tamires
del regs["Tamires"]

# f) Print o tamanho do dicionário
print(len(regs))



