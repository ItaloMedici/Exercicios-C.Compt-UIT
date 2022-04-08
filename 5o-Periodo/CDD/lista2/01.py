""" - Escreva um programa Python para combinar dois dicionários adicionando valores para
chaves comuns.  """

def sumDict(d1, d2):
  dFinal = d1.copy()

  for c in d2.keys():
    if (dFinal.get(c)):
      dFinal[c] += d2[c]
    else:
      dFinal[c] = d2[c]

  return dFinal

d1 = {'a': 100, 'b': 200, 'c':300}
d2 = {'a': 300, 'b': 200, 'd':400}

print(sumDict(d1, d2))