using System;

class Program {
    static void Main() {
        int[,] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Console.WriteLine("======= DECLARACION, INICIALIZACION Y RECORRIDO EN MATRIZ 3X3 =======");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                Console.Write(matriz[i, j]);
            }
            Console.WriteLine();
        }

        Console.WriteLine("RECORRIDO INVERSO EN UNA MATRIZ 3X3");
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                Console.Write(matriz[i, j]);
            }
            Console.WriteLine();
        }
    }
}
