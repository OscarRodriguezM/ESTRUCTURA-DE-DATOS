# Declaración e inicialización de matriz 3x3
matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

print("======= DECLARACION, INICIALIZACION Y RECORRIDO EN MATRIZ 3X3 =======")
for i in range(3):
    for j in range(3):
        print(matriz[i][j], end="")
    print()

print("RECORRIDO INVERSO EN UNA MATRIZ 3X3")
for i in range(2, -1, -1):
    for j in range(2, -1, -1):
        print(matriz[i][j], end="")
    print()
