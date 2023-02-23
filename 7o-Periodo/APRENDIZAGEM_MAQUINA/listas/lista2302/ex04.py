"""
4) Crie uma lista vazia:
  a) Adicione 5 elementos de uma lista de compras de supermercado (a sua escolha);
  b) Remova o último elemento;
  c) Adicione mais 3 elementos (a sua escolha);
  d) Print apenas os dois primeiros elementos;
  e) Print apenas os 3 últimos elementos;
"""

compras = []

compras.append('agua',)
compras.append('cafe')
compras.append('açucar')
compras.append('filtro')
compras.append('leite')

compras.pop()

compras.append('batata')
compras.append('arroz')
compras.append('gelo')

print(compras[:2], compras[-3:])
