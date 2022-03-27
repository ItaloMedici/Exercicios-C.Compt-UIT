file = open("lista1/16.txt", "r")

dct = {}

for line in file:
  for letter in line: 
    letter = letter.lower()
    if (letter in dct):
      dct[letter] = dct[letter] + 1
    elif (letter != "\n" and letter != " "):
      dct[letter] = 1

print(dct)