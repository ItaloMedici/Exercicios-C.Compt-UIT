""" Faça um programa que leia um número n e em seguida leia n inteiros. Em seguida crie
uma lista com o quadrado dos elementos da lista original utilizando compreensão de lista. """

import numpy as np

n = int(input("n: "))
listaoriginal = np.random.randint(1, 10, n)

listaAoQuadrado = [num**2 for num in listaoriginal]

print(listaAoQuadrado)