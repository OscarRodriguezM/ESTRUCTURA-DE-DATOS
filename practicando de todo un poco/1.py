print("INTENTANDO ENTENDER PYTHON unu")

# CREAR ARREGLO VACÍO DE 10 ELEMENTOS
arreglo = [0] * 10  # [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

# LLENAR CON FOR - NÚMEROS DEL 1 AL 10
for i in range(10):
    arreglo[i] = i + 1

print("Arreglo:", arreglo)


# SOLICITAR TAMAÑO AL USUARIO
n = int(input("Ingrese el tamaño del arreglo: "))

# CREAR ARREGLO VACÍO
arreglo = [0] * n

# LLENAR CON FOR
for i in range(n):
    arreglo[i] = i + 1

print(f"Arreglo de {n} elementos: {arreglo}")


# ARREGLO CON VALORES INGRESADOS POR EL USUARIO
n = int(input("¿Cuántos números quiere ingresar? "))
numeros = []

print(f"Ingrese {n} números:")
for i in range(n):
    valor = int(input(f"Número {i+1}: "))
    numeros.append(valor)

print(f"Arreglo resultante: {numeros}")

# INGRESAR VALORES EN VARIABLES
nombre = input("Ingrese su nombre: ")
# MOSTRAR MENSAJES
print(f"Hola, {nombre}!")



# SIN APPEND - CON TAMAÑO CONOCIDO
n = 3
valores = [0] * n  # Crear arreglo de 3 ceros

print(f"Ingrese {n} valores:")
for i in range(n):
    valores[i] = int(input(f"Valor {i+1}: "))  # Asignación directa

print(f"Valores ingresados: {valores}")

