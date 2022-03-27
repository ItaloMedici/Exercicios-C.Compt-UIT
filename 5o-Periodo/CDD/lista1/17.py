
import matplotlib.pyplot as plt

file = open("lista1/16.txt", "r")

dct = {}

for line in file:
  for letter in line: 
    letter = letter.lower()
    if (letter in dct):
      dct[letter] = dct[letter] + 1
    elif (letter != "\n" and letter != " "):
      dct[letter] = 1

names = list(dct.keys())
values = list(dct.values())

plt.bar(range(len(dct)), values, tick_label=names)
plt.show()
