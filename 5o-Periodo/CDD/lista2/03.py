""" Escreva um programa em Python que print os três tens com valor mais alto do dicionário """

from numpy import Infinity


dicionario = {'item1': 45.50, 'item2':35, 'item3': 41.30, 'item4':55, 'item5': 24}
top3 = {}

for c in range(len(dicionario)):
  if len(top3) == 3: break

  item = ''
  maior = 0
  maiorDtc = {}

  for i, k in dicionario.items():
    if k > maior:
      maior = k
      item = i
      maiorDtc = {i: k}
    
  top3.update(maiorDtc)
  if dicionario[item]: del dicionario[item]

[print(i, k) for i, k in top3.items()]