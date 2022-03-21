""" Faça um programa que leia um número n e em seguida leia n inteiros. Crie uma lista
ordenada sem elementos repetidos a partir da lista original e mostre a lista original e a lista
ordenada sem elementos repetidos na tela
 """

import numpy as np

n = int(input("n: "))
listaoriginal = np.random.randint(1, 100, n)

print(listaoriginal)
print(list(set(np.sort(listaoriginal))))