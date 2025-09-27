import java.util.Scanner;

public class battleship {

    public static void main(String[] args) {
        // DECLARACIÓN DE TODAS LAS VARIABLES AL INICIO
        char[][] tabla = new char[10][10];
        Scanner sc = new Scanner(System.in);
        int fila = 0;
        int columna = 0;
        int tamano = 0;
        char orientacion = ' ';
        int posicionValida = 0;
        int i = 0;
        int j = 0;
        int piezasDisponibles = 3;
        int[] tamanosPiezas = {2, 3, 4};
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
        
        System.out.println("======= BATTLESHIP BETA V0.1 =======");

        // AQUI SE LLENA EL TABLERO CON *
        for (i = 0; i <= 9; i++) {
            for (j = 0; j <= 9; j++) {
                tabla[i][j] = '*';
            }
        }

        // CICLO PRINCIPAL MIENTRAS QUEDEN PIEZAS
        while (piezasDisponibles > 0 && salir == 0) {
            
            // MOSTRAR ESTADO
            System.out.println("PIEZAS DISPONIBLES: " + piezasDisponibles);
            
            // AQUI MOSTRAMOS LOS NUMEROS QUE SIRVEN COMO COORDENADAS
            System.out.print("   ");
            for (j = 0; j <= 9; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();

            // AQUI MOSTRAMOS EL TABLERO
            for (i = 0; i <= 9; i++) {
                System.out.print((i + 1) + "  "); // MUESTRA LOS NUMEROS DE LAS FILAS
                for (j = 0; j <= 9; j++) {
                    System.out.print(tabla[i][j] + " ");
                }
                System.out.println();
            }

            // MENÚ SIMPLE
            System.out.println("1. AGREGAR PIEZA");
            System.out.println("2. CAMBIAR ORIENTACION DE PIEZA");
            System.out.println("3. ELIMINAR PIEZA");
            System.out.println("4. SALIR");
            System.out.print("SELECCIONE OPCION: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                // AGREGAR NUEVA PIEZA
                System.out.println("TAMAÑOS DISPONIBLES: ");
                for (i = 0; i < tamanosPiezas.length; i++) {
                    System.out.println((i+1) + ". TAMAÑO " + tamanosPiezas[i]);
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

                        // VERIFICAMOS SI LA POSICIÓN ES VÁLIDA
                        if (orientacion == 'H') {
                            if (columna + tamano <= 10) {
                                posicionValida = 1;
                            } else {
                                System.out.println("NO CABE EL BARCO EN HORIZONTAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else if (orientacion == 'V') {
                            if (fila + tamano <= 10) {
                                posicionValida = 1;
                            } else {
                                System.out.println("NO CABE EL BARCO EN VERTICAL EN ESA POSICION. INTENTE DE NUEVO.");
                            }
                        } else {
                            System.out.println("ORIENTACION INVALIDA. USE H PARA HORIZONTAL O V PARA VERTICAL. INTENTE DE NUEVO.");
                        }
                    }

                    // INSERTA EL BARCO EN EL TABLERO
                    if (orientacion == 'H') {
                        for (j = columna; j < columna + tamano; j++) {
                            tabla[fila][j] = 'B';
                        }
                    } else if (orientacion == 'V') {
                        for (i = fila; i < fila + tamano; i++) {
                            tabla[i][columna] = 'B';
                        }
                    }
                    
                    piezasDisponibles--;
                    System.out.println("PIEZA AGREGADA EXITOSAMENTE!");

                } else {
                    System.out.println("SELECCION INVALIDA");
                }

            } else if (opcion == 2) {
                // CAMBIAR ORIENTACION DE PIEZA EXISTENTE
                System.out.print("INGRESE FILA DE LA PIEZA A CAMBIAR: ");
                filaCambiar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A CAMBIAR: ");
                columnaCambiar = sc.nextInt() - 1;

                // VERIFICAR SI HAY UNA PIEZA EN ESA POSICION
                if (filaCambiar >= 0 && filaCambiar <= 9 && columnaCambiar >= 0 && columnaCambiar <= 9) {
                    if (tabla[filaCambiar][columnaCambiar] == 'B') {
                        
                        // DETECTAR SI LA PIEZA ES HORIZONTAL O VERTICAL
                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;
                        
                        // VERIFICAR HORIZONTAL
                        if (columnaCambiar < 9 && tabla[filaCambiar][columnaCambiar + 1] == 'B') {
                            esHorizontal = 1;
                            // CONTAR TAMAÑO
                            for (j = columnaCambiar; j < 10 && tabla[filaCambiar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--; // AJUSTAR
                        } 
                        // VERIFICAR VERTICAL
                        else if (filaCambiar < 9 && tabla[filaCambiar + 1][columnaCambiar] == 'B') {
                            esVertical = 1;
                            // CONTAR TAMAÑO
                            for (i = filaCambiar; i < 10 && tabla[i][columnaCambiar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--; // AJUSTAR
                        }
                        
                        System.out.print("LA PIEZA ES " + (esHorizontal == 1 ? "HORIZONTAL" : "VERTICAL") + 
                                       ". CAMBIAR ORIENTACION? (S/N): ");
                        cambiar = sc.next().charAt(0);
                        
                        if (cambiar == 'S' || cambiar == 's') {
                            
                            // QUITAR LA PIEZA ACTUAL
                            if (esHorizontal == 1) {
                                for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                    tabla[filaCambiar][j] = '*';
                                }
                            } else {
                                for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                    tabla[i][columnaCambiar] = '*';
                                }
                            }
                            
                            // INTENTAR COLOCAR CON NUEVA ORIENTACION
                            cambioExitoso = 0;
                            char nuevaOrientacion = esHorizontal == 1 ? 'V' : 'H';
                            
                            if (nuevaOrientacion == 'H') {
                                if (columnaCambiar + tamanoPieza <= 10) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tabla[filaCambiar][j] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            } else {
                                if (filaCambiar + tamanoPieza <= 10) {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tabla[i][columnaCambiar] = 'B';
                                    }
                                    cambioExitoso = 1;
                                }
                            }
                            
                            if (cambioExitoso == 1) {
                                System.out.println("ORIENTACION CAMBIADA EXITOSAMENTE!");
                            } else {
                                // VOLVER A COLOCAR EN ORIENTACION ORIGINAL
                                if (esHorizontal == 1) {
                                    for (j = columnaCambiar; j < columnaCambiar + tamanoPieza; j++) {
                                        tabla[filaCambiar][j] = 'B';
                                    }
                                } else {
                                    for (i = filaCambiar; i < filaCambiar + tamanoPieza; i++) {
                                        tabla[i][columnaCambiar] = 'B';
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
                // ELIMINAR PIEZA
                System.out.print("INGRESE FILA DE LA PIEZA A ELIMINAR: ");
                filaEliminar = sc.nextInt() - 1;
                System.out.print("INGRESE COLUMNA DE LA PIEZA A ELIMINAR: ");
                columnaEliminar = sc.nextInt() - 1;

                // VERIFICAR SI HAY UNA PIEZA EN ESA POSICION
                if (filaEliminar >= 0 && filaEliminar <= 9 && columnaEliminar >= 0 && columnaEliminar <= 9) {
                    if (tabla[filaEliminar][columnaEliminar] == 'B') {
                        
                        // DETECTAR SI LA PIEZA ES HORIZONTAL O VERTICAL
                        esHorizontal = 0;
                        esVertical = 0;
                        tamanoPieza = 1;
                        
                        // VERIFICAR HORIZONTAL
                        if (columnaEliminar < 9 && tabla[filaEliminar][columnaEliminar + 1] == 'B') {
                            esHorizontal = 1;
                            // CONTAR TAMAÑO
                            for (j = columnaEliminar; j < 10 && tabla[filaEliminar][j] == 'B'; j++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--; // AJUSTAR
                        } 
                        // VERIFICAR VERTICAL
                        else if (filaEliminar < 9 && tabla[filaEliminar + 1][columnaEliminar] == 'B') {
                            esVertical = 1;
                            // CONTAR TAMAÑO
                            for (i = filaEliminar; i < 10 && tabla[i][columnaEliminar] == 'B'; i++) {
                                tamanoPieza++;
                            }
                            tamanoPieza--; // AJUSTAR
                        }
                        
                        System.out.print("SE ELIMINARA UNA PIEZA DE TAMAÑO " + tamanoPieza + 
                                       ". ESTA SEGURO? (S/N): ");
                        cambiar = sc.next().charAt(0);
                        
                        if (cambiar == 'S' || cambiar == 's') {
                            
                            // ELIMINAR LA PIEZA
                            if (esHorizontal == 1) {
                                for (j = columnaEliminar; j < columnaEliminar + tamanoPieza; j++) {
                                    tabla[filaEliminar][j] = '*';
                                }
                            } else {
                                for (i = filaEliminar; i < filaEliminar + tamanoPieza; i++) {
                                    tabla[i][columnaEliminar] = '*';
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

        // MOSTRAR TABLERO FINAL
        System.out.println("======= TABLERO FINAL =======");
        System.out.print("   ");
        for (j = 0; j <= 9; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (i = 0; i <= 9; i++) {
            System.out.print((i + 1) + "  ");
            for (j = 0; j <= 9; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("JUEGO TERMINADO!");
    }
}
