jugador1 = "O"
jugador2 = "X"

while True:
    print("======= JUEGO 4 EN RAYA =======")
    tablero = [[" " for _ in range(7)] for _ in range(6)]
    turno = 0
    ganador = False

    while True:
        # MOSTRAR EL TABLERO DEL JUEGO
        print(" 0 1 2 3 4 5 6")
        for fila in tablero:
            print("|".join(fila))
            print("=" * 13)

        jugador_actual = jugador1 if turno % 2 == 0 else jugador2

        # PEDIR LA COLUMNA
        while True:
            try:
                columna = int(input(f"TURNO DEL JUGADOR {jugador_actual}. ELIGE UNA COLUMNA DEL 0 AL 6: "))
                if columna < 0 or columna > 6:
                    print("COLUMNA INVÁLIDA. INTENTA DE NUEVO.")
                elif tablero[0][columna] != " ":
                    print("COLUMNA LLENA. INTENTA DE NUEVO.")
                else:
                    break
            except ValueError:
                print("ENTRADA INVÁLIDA. INGRESA UN NÚMERO ENTRE 0 Y 6.")

        # Colocar ficha en la fila más baja disponible
        for fila in range(5, -1, -1):
            if tablero[fila][columna] == " ":
                tablero[fila][columna] = jugador_actual
                break

        # Validar ganador (horizontal, vertical y diagonales)
        # Horizontal
        for f in range(6):
            for c in range(4):
                if (tablero[f][c] == jugador_actual and
                    tablero[f][c+1] == jugador_actual and
                    tablero[f][c+2] == jugador_actual and
                    tablero[f][c+3] == jugador_actual):
                    ganador = True
        # Vertical
        for f in range(3):
            for c in range(7):
                if (tablero[f][c] == jugador_actual and
                    tablero[f+1][c] == jugador_actual and
                    tablero[f+2][c] == jugador_actual and
                    tablero[f+3][c] == jugador_actual):
                    ganador = True
        # Diagonal principal
        for f in range(3):
            for c in range(4):
                if (tablero[f][c] == jugador_actual and
                    tablero[f+1][c+1] == jugador_actual and
                    tablero[f+2][c+2] == jugador_actual and
                    tablero[f+3][c+3] == jugador_actual):
                    ganador = True
        # Diagonal secundaria
        for f in range(3, 6):
            for c in range(4):
                if (tablero[f][c] == jugador_actual and
                    tablero[f-1][c+1] == jugador_actual and
                    tablero[f-2][c+2] == jugador_actual and
                    tablero[f-3][c+3] == jugador_actual):
                    ganador = True

        if ganador:
            print(" 0 1 2 3 4 5 6")
            for fila in tablero:
                print("|".join(fila))
                print("=" * 13)
            print(f"EL JUGADOR {jugador_actual} HA GANADO")
            break

        # VALIDAR EL EMPATE
        lleno = True
        for fila in tablero:
            if " " in fila:
                lleno = False
                break
        if lleno:
            print(" 0 1 2 3 4 5 6")
            for fila in tablero:
                print("|".join(fila))
                print("=" * 13)
            print("EL JUEGO HA TERMINADO EN EMPATE")
            break

        turno += 1
        print()

    jugar_nuevamente = input("¿DESEA JUGAR NUEVAMENTE? (S/N): ").strip().lower()
    if jugar_nuevamente != "s":
        print("¡GRACIAS POR JUGAR!")
        break
