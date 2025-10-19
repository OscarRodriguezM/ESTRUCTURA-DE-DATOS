# Bucle "for-each" (el más común)
numeros = [1, 2, 3]
for n in numeros:
    print(n)

# Bucle "for" tradicional (si necesitas el índice)
# range(5) genera 0, 1, 2, 3, 4
for i in range(len(numeros)):
    print(f"Índice {i}: {numeros[i]}")

# Funciones (def = definir)
def sumar(a, b):
    # ¡Nota la indentación!
    resultado = a + b
    return resultado

# Llamar la función
total = sumar(5, 10)