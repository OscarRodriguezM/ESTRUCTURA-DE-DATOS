import java.util.Scanner;

public class battleship {

    public static void main(String[] args) {
        // DECLARACIÓN DE TODAS LAS VARIABLES AL INICIO
        char[][] tablaJugador1 = new char[10][10];
        char[][] tablaJugador2 = new char[10][10];
        char[][] tableroAtaqueJ1 = new char[10][10];
        char[][] tableroAtaqueJ2 = new char[10][10];
        Scanner sc = new Scanner(System.in);
        int fila = 0;
        int columna = 0;
        int tamano = 0;
        char orientacion = ' ';
        int posicionValida = 0;
        int i = 0;
        int j = 0;
        int piezasDisponibles = 3;
        int[] tamanosPiezas = { 2, 3, 4 };
        int salir = 0;
        char cambiar = ' ';
        int filaCambiar = 0;
        int columnaCambiar = 0;
        int opcion = 0;
        int seleccion = 0;
        int cambioExitoso = 0;
        int esHorizontal = 0;
        int esVertical = 0;
        int tamanoPieza = 0;
        int filaEliminar = 0;
        int columnaEliminar = 0;
        int jugadorActual = 1;
        int filaAtaque = 0;
        int columnaAtaque = 0;
        int barcosJugador1 = 0;
        int barcosJugador2 = 0;
        int juegoTerminado = 0;
        int ganador = 0;

        System.out.println("======= BATTLESHIP COMPLETO =======");

        // INICIALIZAR TABLEROS CON *
        for (i = 0; i <= 9; i++) {
            for (j = 0; j <= 9; j++) {
                tablaJugador1[i][j] = '*';
                tablaJugador2[i][j] = '*';
                tableroAtaqueJ1[i][j] = '*';
                tableroAtaqueJ2[i][j] = '*';
            }
        }

        // FASE DE COLOCACIÓN DE BARCOS - JUGADOR 1
        System.out.println("======= JUGADOR 1 - COLOCA TUS BARCOS ========");
        piezasDisponibles = 3;
        while (piezasDisponibles > 0 && salir == 0) {

            System.out.println("PIEZAS DISPONIBLES: " + piezasDisponibles);

            System.out.print("   ");
            for (j = 0; j <= 9; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();

            for (i = 0; i <= 9; i++) {
                System.out.print((i + 1) + "  ");
                for (j = 0; j <= 9; j++) {
                    System.out.print(tablaJugador1[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("1. AGREGAR PIEZA");
            System.out.println("2. CAMBIAR ORIENTACION DE PIEZA");
            System.out.println("3. ELIMINAR PIEZA");
            System.out.println("4. TERMINAR COLOCACION");
            System.out.print("SELECCIONE OPCION: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("TAMAÑOS DISPONIBLES: ");
                for (i = 0; i < tamanosPiezas.length; i++) {
                    System.out.println((i + 1) + ". TAMAÑO " + tamanosPiezas[i]);
                }
                System.out.print("SELECCIONE TAMAÑO (1-" + tamanosPiezas.length + "): ");
                seleccion = sc.nextInt() - 1;

                if (seleccion >= 0 && seleccion < tamanosPiezas.length) {
                    tamano = tamanosPiezas[seleccion];
                    posicionValida = 0;

                    while (posicionValida == 0) {
                        System.out.print("INGRESE EL NUMERO DE FILA: ");
                        fila = sc.nextInt() - 1;
                        System.out.print("INGRESE EL NUMERO DE COLUMNA: ");
                        columna = sc.nextInt() - 1;
                        System.out.print("DESEA COLOCARLO HORIZONTAL (H) O VERTICAL (V)? ");
                        orientacion = sc.next().charAt(0);

                        // VERIFICAR POSICIÓN VÁLIDA
                        if (orientacion == 'H' || orientacion == 'h') {
                            if (columna + tamano <= 10) {
                                // VERIFICAR QUE NO HAY BARCOS EN ESA POSICIÓN
                                boolean espacioLibre = true;
                                for (j = columna; j < columna + tamano; j++) {
                                    if (tablaJugador1[fila][j] != '*') {
                                        espacioLibre = false;
                                        break;
                                    }
                                }
                                if (espacioLibre) {
                                    posicionValida = 1;
                                } else {
                                    System.out.println("YA HAY UN BARCO EN ESA POSICION. INTENTE DE NUEVO.");
                                }
                            } else {
                                System.out.println("NO CABE EL BARCO EN HORIZONTAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else if (orientacion == 'V' || orientacion == 'v') {
                            if (fila + tamano <= 10) {
                                // VERIFICAR QUE NO HAY BARCOS EN ESA POSICIÓN
                                boolean espacioLibre = true;
                                for (i = fila; i < fila + tamano; i++) {
                                    if (tablaJugador1[i][columna] != '*') {
                                        espacioLibre = false;
                                        break;
                                    }
                                }
                                if (espacioLibre) {
                                    posicionValida = 1;
                                } else {
                                    System.out.println("YA HAY UN BARCO EN ESA POSICION. INTENTE DE NUEVO.");
                                }
                            } else {
                                System.out.println("NO CABE EL BARCO EN VERTICAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else {
                            System.out.println(
                                    "ORIENTACION INVALIDA. USE H PARA HORIZONTAL O V PARA VERTICAL. INTENTE DE NUEVO.");
                        }
                    }

                    // INSERTAR BARCO
                    if (orientacion == 'H' || orientacion == 'h') {
                        for (j = columna; j < columna + tamano; j++) {
                            tablaJugador1[fila][j] = 'B';
                        }
                    } else if (orientacion == 'V' || orientacion == 'v') {
                        for (i = fila; i < fila + tamano; i++) {
                            tablaJugador1[i][columna] = 'B';
                        }
                    }

                    piezasDisponibles--;
                    System.out.println("PIEZA AGREGADA EXITOSAMENTE!");

                } else {
                    System.out.println("SELECCION INVALIDA");
                }

            } else if (opcion == 2) {
                // CAMBIAR ORIENTACIÓN
                System.out.print("INGRESE FILA DE LA PIEZA A CAMBIAR: ");
                filaCambiar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A CAMBIAR: ");
                columnaCambiar = sc.nextInt() - 1;

                if (filaCambiar >= 0 && filaCambiar <= 9 && columnaCambiar >= 0 && columnaCambiar <= 9) {
                    if (tablaJugador1[filaCambiar][columnaCambiar] == 'B') {

                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;

                        if (columnaCambiar < 9 && tablaJugador1[filaCambiar][columnaCambiar + 1] == 'B') {
                            esHorizontal = 1;
                            for (j = columnaCambiar; j < 10 && tablaJugador1[filaCambiar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        } else if (filaCambiar < 9 && tablaJugador1[filaCambiar + 1][columnaCambiar] == 'B') {
                            esVertical = 1;
                            for (i = filaCambiar; i < 10 && tablaJugador1[i][columnaCambiar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        }

                        System.out.print("LA PIEZA ES " + (esHorizontal == 1 ? "HORIZONTAL" : "VERTICAL") +
                                ". CAMBIAR ORIENTACION? (S/N): ");
                        cambiar = sc.next().charAt(0);

                        if (cambiar == 'S' || cambiar == 's') {

                            if (esHorizontal == 1) {
                                for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                    tablaJugador1[filaCambiar][j] = '*';
                                }
                            } else {
                                for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                    tablaJugador1[i][columnaCambiar] = '*';
                                }
                            }

                            cambioExitoso = 0;
                            char nuevaOrientacion = esHorizontal == 1 ? 'V' : 'H';

                            if (nuevaOrientacion == 'H' || nuevaOrientacion == 'h') {
                                if (columnaCambiar + tamanoPieza <= 10) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tablaJugador1[filaCambiar][j] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            } else {
                                if (filaCambiar + tamanoPieza <= 10) {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tablaJugador1[i][columnaCambiar] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            }

                            if (cambioExitoso == 1) {
                                System.out.println("ORIENTACION CAMBIADA EXITOSAMENTE!");
                            } else {
                                if (esHorizontal == 1) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tablaJugador1[filaCambiar][j] = 'B';
                                    }
                                } else {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tablaJugador1[i][columnaCambiar] = 'B';
                                    }
                                }
                                System.out.println("NO SE PUEDE CAMBIAR LA ORIENTACION. NO HAY ESPACIO.");
                            }
                        }
                    } else {
                        System.out.println("NO HAY PIEZA EN ESA POSICION");
                    }
                } else {
                    System.out.println("POSICION INVALIDA");
                }

            } else if (opcion == 3) {
                // CÓDIGO PARA ELIMINAR PIEZA
                System.out.print("INGRESE FILA DE LA PIEZA A ELIMINAR: ");
                filaEliminar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A ELIMINAR: ");
                columnaEliminar = sc.nextInt() - 1;

                if (filaEliminar >= 0 && filaEliminar <= 9 && columnaEliminar >= 0 && columnaEliminar <= 9) {
                    if (tablaJugador1[filaEliminar][columnaEliminar] == 'B') {

                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;

                        if (columnaEliminar < 9 && tablaJugador1[filaEliminar][columnaEliminar + 1] == 'B') {
                            esHorizontal = 1;
                            for (j = columnaEliminar; j < 10 && tablaJugador1[filaEliminar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        } else if (filaEliminar < 9 && tablaJugador1[filaEliminar + 1][columnaEliminar] == 'B') {
                            esVertical = 1;
                            for (i = filaEliminar; i < 10 && tablaJugador1[i][columnaEliminar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        }

                        System.out.print("SE ELIMINARA UNA PIEZA DE TAMAÑO " + tamanoPieza +
                                ". ESTA SEGURO? (S/N): ");
                        cambiar = sc.next().charAt(0);

                        if (cambiar == 'S' || cambiar == 's') {

                            if (esHorizontal == 1) {
                                for (j = columnaEliminar; j < columnaEliminar + tamanoPieza; j++) {
                                    tablaJugador1[filaEliminar][j] = '*';
                                }
                            } else {
                                for (i = filaEliminar; i < filaEliminar + tamanoPieza; i++) {
                                    tablaJugador1[i][columnaEliminar] = '*';
                                }
                            }

                            piezasDisponibles++;
                            System.out.println("PIEZA ELIMINADA EXITOSAMENTE!");
                        }
                    } else {
                        System.out.println("NO HAY PIEZA EN ESA POSICION");
                    }
                } else {
                    System.out.println("POSICION INVALIDA");
                }

            } else if (opcion == 4) {
                salir = 1;
            } else {
                System.out.println("OPCION INVALIDA");
            }
        }

        // FASE DE COLOCACIÓN DE BARCOS - JUGADOR 2
        System.out.println("\n\n=== JUGADOR 2 - COLOCA TUS BARCOS ===");
        piezasDisponibles = 3;
        salir = 0;

        while (piezasDisponibles > 0 && salir == 0) {

            System.out.println("PIEZAS DISPONIBLES: " + piezasDisponibles);

            System.out.print("   ");
            for (j = 0; j <= 9; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();

            for (i = 0; i <= 9; i++) {
                System.out.print((i + 1) + "  ");
                for (j = 0; j <= 9; j++) {
                    System.out.print(tablaJugador2[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("1. AGREGAR PIEZA");
            System.out.println("2. CAMBIAR ORIENTACION DE PIEZA");
            System.out.println("3. ELIMINAR PIEZA");
            System.out.println("4. TERMINAR COLOCACION");
            System.out.print("SELECCIONE OPCION: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("TAMAÑOS DISPONIBLES: ");
                for (i = 0; i < tamanosPiezas.length; i++) {
                    System.out.println((i + 1) + ". TAMAÑO " + tamanosPiezas[i]);
                }
                System.out.print("SELECCIONE TAMAÑO (1-" + tamanosPiezas.length + "): ");
                seleccion = sc.nextInt() - 1;

                if (seleccion >= 0 && seleccion < tamanosPiezas.length) {
                    tamano = tamanosPiezas[seleccion];
                    posicionValida = 0;

                    while (posicionValida == 0) {
                        System.out.print("INGRESE EL NUMERO DE FILA: ");
                        fila = sc.nextInt() - 1;
                        System.out.print("INGRESE EL NUMERO DE COLUMNA: ");
                        columna = sc.nextInt() - 1;
                        System.out.print("DESEA COLOCARLO HORIZONTAL (H) O VERTICAL (V)? ");
                        orientacion = sc.next().charAt(0);

                        if (orientacion == 'H' || orientacion == 'h') {
                            if (columna + tamano <= 10) {
                                boolean espacioLibre = true;
                                for (j = columna; j < columna + tamano; j++) {
                                    if (tablaJugador2[fila][j] != '*') {
                                        espacioLibre = false;
                                        break;
                                    }
                                }
                                if (espacioLibre) {
                                    posicionValida = 1;
                                } else {
                                    System.out.println("YA HAY UN BARCO EN ESA POSICION. INTENTE DE NUEVO.");
                                }
                            } else {
                                System.out.println("NO CABE EL BARCO EN HORIZONTAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else if (orientacion == 'V' || orientacion == 'v') {
                            if (fila + tamano <= 10) {
                                boolean espacioLibre = true;
                                for (i = fila; i < fila + tamano; i++) {
                                    if (tablaJugador2[i][columna] != '*') {
                                        espacioLibre = false;
                                        break;
                                    }
                                }
                                if (espacioLibre) {
                                    posicionValida = 1;
                                } else {
                                    System.out.println("YA HAY UN BARCO EN ESA POSICION. INTENTE DE NUEVO.");
                                }
                            } else {
                                System.out.println("NO CABE EL BARCO EN VERTICAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else {
                            System.out.println(
                                    "ORIENTACION INVALIDA. USE H PARA HORIZONTAL O V PARA VERTICAL. INTENTE DE NUEVO.");
                        }
                    }

                    if (orientacion == 'H' || orientacion == 'h') {
                        for (j = columna; j < columna + tamano; j++) {
                            tablaJugador2[fila][j] = 'B';
                        }
                    } else if (orientacion == 'V' || orientacion == 'v') {
                        for (i = fila; i < fila + tamano; i++) {
                            tablaJugador2[i][columna] = 'B';
                        }
                    }

                    piezasDisponibles--;
                    System.out.println("PIEZA AGREGADA EXITOSAMENTE!");

                } else {
                    System.out.println("SELECCION INVALIDA");
                }

            } else if (opcion == 2) {
                // CODIGO PARA CAMBIAR ORIENTACIÓN (SIMILAR AL JUGADOR 1)
                System.out.print("INGRESE FILA DE LA PIEZA A CAMBIAR: ");
                filaCambiar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A CAMBIAR: ");
                columnaCambiar = sc.nextInt() - 1;

                if (filaCambiar >= 0 && filaCambiar <= 9 && columnaCambiar >= 0 && columnaCambiar <= 9) {
                    if (tablaJugador2[filaCambiar][columnaCambiar] == 'B') {

                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;

                        if (columnaCambiar < 9 && tablaJugador2[filaCambiar][columnaCambiar + 1] == 'B') {
                            esHorizontal = 1;
                            for (j = columnaCambiar; j < 10 && tablaJugador2[filaCambiar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        } else if (filaCambiar < 9 && tablaJugador2[filaCambiar + 1][columnaCambiar] == 'B') {
                            esVertical = 1;
                            for (i = filaCambiar; i < 10 && tablaJugador2[i][columnaCambiar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        }

                        System.out.print("LA PIEZA ES " + (esHorizontal == 1 ? "HORIZONTAL" : "VERTICAL") +
                                ". CAMBIAR ORIENTACION? (S/N): ");
                        cambiar = sc.next().charAt(0);

                        if (cambiar == 'S' || cambiar == 's') {

                            if (esHorizontal == 1) {
                                for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                    tablaJugador2[filaCambiar][j] = '*';
                                }
                            } else {
                                for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                    tablaJugador2[i][columnaCambiar] = '*';
                                }
                            }

                            cambioExitoso = 0;
                            char nuevaOrientacion = esHorizontal == 1 ? 'V' : 'H';

                            if (nuevaOrientacion == 'H' || nuevaOrientacion == 'h') {
                                if (columnaCambiar + tamanoPieza <= 10) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tablaJugador2[filaCambiar][j] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            } else {
                                if (filaCambiar + tamanoPieza <= 10) {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tablaJugador2[i][columnaCambiar] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            }

                            if (cambioExitoso == 1) {
                                System.out.println("ORIENTACION CAMBIADA EXITOSAMENTE!");
                            } else {
                                if (esHorizontal == 1) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tablaJugador2[filaCambiar][j] = 'B';
                                    }
                                } else {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tablaJugador2[i][columnaCambiar] = 'B';
                                    }
                                }
                                System.out.println("NO SE PUEDE CAMBIAR LA ORIENTACION. NO HAY ESPACIO.");
                            }
                        }
                    } else {
                        System.out.println("NO HAY PIEZA EN ESA POSICION");
                    }
                } else {
                    System.out.println("POSICION INVALIDA");
                }

            } else if (opcion == 3) {
                // CODIGO PARA ELIMINAR PIEZA (SIMILAR AL JUGADOR 1)
                System.out.print("INGRESE FILA DE LA PIEZA A ELIMINAR: ");
                filaEliminar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A ELIMINAR: ");
                columnaEliminar = sc.nextInt() - 1;

                if (filaEliminar >= 0 && filaEliminar <= 9 && columnaEliminar >= 0 && columnaEliminar <= 9) {
                    if (tablaJugador2[filaEliminar][columnaEliminar] == 'B') {

                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;

                        if (columnaEliminar < 9 && tablaJugador2[filaEliminar][columnaEliminar + 1] == 'B') {
                            esHorizontal = 1;
                            for (j = columnaEliminar; j < 10 && tablaJugador2[filaEliminar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        } else if (filaEliminar < 9 && tablaJugador2[filaEliminar + 1][columnaEliminar] == 'B') {
                            esVertical = 1;
                            for (i = filaEliminar; i < 10 && tablaJugador2[i][columnaEliminar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--;
                        }

                        System.out.print("SE ELIMINARA UNA PIEZA DE TAMAÑO " + tamanoPieza +
                                ". ESTA SEGURO? (S/N): ");
                        cambiar = sc.next().charAt(0);

                        if (cambiar == 'S' || cambiar == 's') {

                            if (esHorizontal == 1) {
                                for (j = columnaEliminar; j < columnaEliminar + tamanoPieza; j++) {
                                    tablaJugador2[filaEliminar][j] = '*';
                                }
                            } else {
                                for (i = filaEliminar; i < filaEliminar + tamanoPieza; i++) {
                                    tablaJugador2[i][columnaEliminar] = '*';
                                }
                            }

                            piezasDisponibles++;
                            System.out.println("PIEZA ELIMINADA EXITOSAMENTE!");
                        }
                    } else {
                        System.out.println("NO HAY PIEZA EN ESA POSICION");
                    }
                } else {
                    System.out.println("POSICION INVALIDA");
                }

            } else if (opcion == 4) {
                salir = 1;
            } else {
                System.out.println("OPCION INVALIDA");
            }
        }

        // FASE DE JUEGO - TURNOS DE ATAQUE
        System.out.println("\n\n======= COMIENZA LA BATALLA =======");
        juegoTerminado = 0;
        jugadorActual = 1;

        while (juegoTerminado == 0) {
            System.out.println("\n======= TURNO DEL JUGADOR " + jugadorActual + " =======");

            // MOSTRAR TABLERO DE ATAQUES DEL JUGADOR ACTUAL
            System.out.println("TABLERO DE TUS ATAQUES:");
            System.out.print("   ");
            for (j = 0; j <= 9; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();

            char[][] tableroAtaqueActual = (jugadorActual == 1) ? tableroAtaqueJ1 : tableroAtaqueJ2;
            for (i = 0; i <= 9; i++) {
                System.out.print((i + 1) + "  ");
                for (j = 0; j <= 9; j++) {
                    System.out.print(tableroAtaqueActual[i][j] + " ");
                }
                System.out.println();
            }

            // SOLICITAR COORDENADAS DE ATAQUE
            System.out.print("INGRESE FILA PARA ATACAR: ");
            filaAtaque = sc.nextInt() - 1;
            System.out.print("INGRESE COLUMNA PARA ATACAR: ");
            columnaAtaque = sc.nextInt() - 1;

            if (filaAtaque >= 0 && filaAtaque <= 9 && columnaAtaque >= 0 && columnaAtaque <= 9) {
                // VERIFICAR SI YA SE ATACO ESA POSICIÓN
                if (tableroAtaqueActual[filaAtaque][columnaAtaque] != '*') {
                    System.out.println("YA ATACASTE ESA POSICION! PIERDES EL TURNO.");
                } else {
                    // VERIFICAR IMPACTO
                    char[][] tableroEnemigo = (jugadorActual == 1) ? tablaJugador2 : tablaJugador1;

                    if (tableroEnemigo[filaAtaque][columnaAtaque] == 'B') {
                        System.out.println("¡IMPACTO! HAS HUNDIDO PARTE DE UN BARCO.");
                        tableroAtaqueActual[filaAtaque][columnaAtaque] = 'X';

                        // VERIFICAR SI SE HUNDIO EL BARCO COMPLETAMENTE
                        boolean barcoHundido = true;
                        if (columnaAtaque > 0 && tableroEnemigo[filaAtaque][columnaAtaque - 1] == 'B') {
                            if ((jugadorActual == 1 && tableroAtaqueJ1[filaAtaque][columnaAtaque - 1] != 'X') ||
                                    (jugadorActual == 2 && tableroAtaqueJ2[filaAtaque][columnaAtaque - 1] != 'X')) {
                                barcoHundido = false;
                            }
                        }
                        if (columnaAtaque < 9 && tableroEnemigo[filaAtaque][columnaAtaque + 1] == 'B') {
                            if ((jugadorActual == 1 && tableroAtaqueJ1[filaAtaque][columnaAtaque + 1] != 'X') ||
                                    (jugadorActual == 2 && tableroAtaqueJ2[filaAtaque][columnaAtaque + 1] != 'X')) {
                                barcoHundido = false;
                            }
                        }
                        if (filaAtaque > 0 && tableroEnemigo[filaAtaque - 1][columnaAtaque] == 'B') {
                            if ((jugadorActual == 1 && tableroAtaqueJ1[filaAtaque - 1][columnaAtaque] != 'X') ||
                                    (jugadorActual == 2 && tableroAtaqueJ2[filaAtaque - 1][columnaAtaque] != 'X')) {
                                barcoHundido = false;
                            }
                        }
                        if (filaAtaque < 9 && tableroEnemigo[filaAtaque + 1][columnaAtaque] == 'B') {
                            if ((jugadorActual == 1 && tableroAtaqueJ1[filaAtaque + 1][columnaAtaque] != 'X') ||
                                    (jugadorActual == 2 && tableroAtaqueJ2[filaAtaque + 1][columnaAtaque] != 'X')) {
                                barcoHundido = false;
                            }
                        }

                        if (barcoHundido) {
                            System.out.println("¡BARCO COMPLETAMENTE HUNDIDO!");
                        }
                    } else {
                        System.out.println("AGUA... NO HAY NINGUN BARCO EN ESA POSICION.");
                        tableroAtaqueActual[filaAtaque][columnaAtaque] = 'O';
                    }
                }
            } else {
                System.out.println("COORDENADAS INVALIDAS! PIERDES EL TURNO.");
            }

            // VERIFICAR SI ALGÚN JUGADOR PERDIÓ TODOS SUS BARCOS
            barcosJugador1 = 0;
            barcosJugador2 = 0;

            for (i = 0; i <= 9; i++) {
                for (j = 0; j <= 9; j++) {
                    if (tablaJugador1[i][j] == 'B') {
                        // VERIFICAR SI ESA PARTE DEL BARCO NO HA SIDO HUNDIDA
                        if (tableroAtaqueJ2[i][j] != 'X') {
                            barcosJugador1++;
                        }
                    }
                    if (tablaJugador2[i][j] == 'B') {
                        // VERIFICAR SI ESA PARTE DEL BARCO NO HA SIDO HUNDIDA
                        if (tableroAtaqueJ1[i][j] != 'X') {
                            barcosJugador2++;
                        }
                    }
                }
            }

            if (barcosJugador1 == 0) {
                juegoTerminado = 1;
                ganador = 2;
            } else if (barcosJugador2 == 0) {
                juegoTerminado = 1;
                ganador = 1;
            } else {
                // CAMBIAR TURNO
                jugadorActual = (jugadorActual == 1) ? 2 : 1;
                System.out.println("PRESIONA ENTER PARA CONTINUAR...");
                sc.nextLine();
                sc.nextLine();
            }
        }

        // MOSTRAR RESULTADO FINAL
        System.out.println("\n\n======= JUEGO TERMINADO =======");
        System.out.println("¡EL JUGADOR " + ganador + " ES EL GANADOR!");

        System.out.println("\nTABLERO FINAL JUGADOR 1:");
        System.out.print("   ");
        for (j = 0; j <= 9; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (i = 0; i <= 9; i++) {
            System.out.print((i + 1) + "  ");
            for (j = 0; j <= 9; j++) {
                System.out.print(tablaJugador1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nTABLERO FINAL JUGADOR 2:");
        System.out.print("   ");
        for (j = 0; j <= 9; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (i = 0; i <= 9; i++) {
            System.out.print((i + 1) + "  ");
            for (j = 0; j <= 9; j++) {
                System.out.print(tablaJugador2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("¡FELICITACIONES AL GANADOR!");
    }
}