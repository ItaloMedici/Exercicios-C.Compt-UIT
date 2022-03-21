from matplotlib import pyplot
import numpy as np

listaoriginal = np.array([5, 12, 10, 5, 10, 19])

print(listaoriginal)
print(list(set(np.sort(listaoriginal))))

pyplot.scatter(listaoriginal, list(set(np.sort(listaoriginal))))
pyplot.title('Gráfico de Dispersão entre data1 e data2')
pyplot.show()