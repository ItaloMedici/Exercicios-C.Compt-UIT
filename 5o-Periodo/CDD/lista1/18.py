produtoNome = []
produtoPreco = []
produto = []

n = int(input("n: "))

for i in range(n):
  produto.append(input())

produto.sort()

for i in range(len(produto)):
  prod = produto[i].split()
  produtoPreco.append(prod.pop())
  produtoNome.append(" ".join(prod))

for i in range(len(produto)):
  print(produtoNome[i], produtoPreco[i])
