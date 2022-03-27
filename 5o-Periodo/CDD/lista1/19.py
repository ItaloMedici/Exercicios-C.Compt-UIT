""" – Crie uma função chamada inverteValor(). Essa função deve receber um inteiro e retornar
o valor usando apenas operações aritméticas. Em seguida crie uma função que recebe o valor
original e o valor invertido e retorna TRUE caso os dois números sejam igualmente pares ou
igualmente ímpares e retorne FALSE caso contrário. """

def inverteValor(num):
  return  0 - num

def isEven(original, inverted):
  return (original%2 == 0 and inverted%2 == 0) or (original%2 == 1 and inverted%2 == 1)

print(isEven(3, inverteValor(3)))