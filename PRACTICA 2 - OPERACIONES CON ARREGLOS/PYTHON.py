print("PRACTICA NO.2 OPERACIONES CON ARREGLOS EN PYTHON")

ar1 = [0] * 4
ar2 = [''] * 4
ar3 = [0.0] * 4
ar4 = [1, 2, 3, 4]
ar5 = ['a', 'b', 'c', 'd']
ar6 = [2.4, 3.0, 23.0, 6.0]
arr = [0 for _ in range(4)]  # "dinámico"

resp = 1
n = 4
posicion = -1

while resp != 2:
    print("======= MENU DE OPERACIONES CON ARREGLOS =======")
    print("1) RECORRIDO")
    print("2) INSERCION")
    print("3) BUSQUEDA")
    print("4) RECORRIDO INVERSO")
    menu = int(input())

    if menu == 1:
        print("======= RECORRIDO EN ARREGLO =======")
        for i in range(4):
            print(ar4[i], end="")
        print()

    elif menu == 2:
        print("======= INSERCION EN EL INDICE =======")
        valor = int(input("INGRESE EL VALOR QUE DESEA INSERTAR: "))

        print("ARREGLO ANTES DE LA INSERCION:")
        for i in range(4):
            print(ar4[i], end="")
        print()

        ar4 = [valor] + ar4[:3]  # inserta al inicio y mantiene tamaño 4

        print("ARREGLO DESPUES DE LA INSERCION:")
        for i in range(4):
            print(ar4[i], end="")
        print()

    elif menu == 3:
        print("======= BUSQUEDA EN ARREGLOS =======")
        valor = int(input("INGRESE EL VALOR QUE DESEA BUSCAR: "))
        posicion = -1
        for i in range(4):
            if ar4[i] == valor:
                posicion = i
                break

        for i in range(4):
            print(ar4[i], end="")
        print()

        if posicion == -1:
            print("EL VALOR INGRESADO NO SE ENCUENTRA EN EL ARREGLO")
        else:
            print(f"EL VALOR: {valor} SE ENCUENTRA EN LA POSICION: {posicion}")

    elif menu == 4:
        print("======= RECORRIDO INVERSO EN ARREGLOS =======")
        for i in range(3, -1, -1):
            print(ar4[i], end="")
        print()

    resp = int(input("DESEA REALIZAR OTRA OPERACION? 1) SI o 2) NO: "))
