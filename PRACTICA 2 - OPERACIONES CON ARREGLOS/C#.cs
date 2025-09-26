using System;

class Program {
    static void Main() {
        int[] ar1 = new int[4];
        char[] ar2 = new char[4];
        float[] ar3 = new float[4];
        int[] ar4 = {1, 2, 3, 4};
        char[] ar5 = {'a', 'b', 'c', 'd'};
        float[] ar6 = {2.4f, 3.0f, 23.0f, 6.0f};
        int[] arr = new int[4];

        int resp = 1, n = 4, posicion = -1, valor, menu;

        Console.WriteLine("PRACTICA NO.2 OPERACIONES CON ARREGLOS EN C#");

        do {
            Console.WriteLine("======= MENU DE OPERACIONES CON ARREGLOS =======");
            Console.WriteLine("1) RECORRIDO");
            Console.WriteLine("2) INSERCION");
            Console.WriteLine("3) BUSQUEDA");
            Console.WriteLine("4) RECORRIDO INVERSO");
            menu = int.Parse(Console.ReadLine());

            switch (menu) {
                case 1:
                    Console.WriteLine("======= RECORRIDO EN ARREGLO =======");
                    for (int i = 0; i < 4; i++) {
                        Console.Write(ar4[i]);
                    }
                    Console.WriteLine();
                    break;

                case 2:
                    Console.WriteLine("======= INSERCION EN EL INDICE =======");
                    Console.WriteLine("INGRESE EL VALOR QUE DESEA INSERTAR:");
                    valor = int.Parse(Console.ReadLine());

                    Console.WriteLine("ARREGLO ANTES DE LA INSERCION:");
                    for (int i = 0; i < 4; i++) {
                        Console.Write(ar4[i]);
                    }
                    Console.WriteLine();

                    for (int i = n - 1; i > 0; i--) {
                        ar4[i] = ar4[i - 1];
                    }
                    ar4[0] = valor;

                    Console.WriteLine("ARREGLO DESPUES DE LA INSERCION:");
                    for (int i = 0; i < 4; i++) {
                        Console.Write(ar4[i]);
                    }
                    Console.WriteLine();
                    break;

                case 3:
                    Console.WriteLine("======= BUSQUEDA EN ARREGLOS =======");
                    Console.WriteLine("INGRESE EL VALOR QUE DESEA BUSCAR:");
                    valor = int.Parse(Console.ReadLine());
                    posicion = -1;

                    for (int i = 0; i < 4; i++) {
                        if (ar4[i] == valor) {
                            posicion = i;
                            break;
                        }
                    }

                    for (int i = 0; i < 4; i++) {
                        Console.Write(ar4[i]);
                    }
                    Console.WriteLine();

                    if (posicion == -1) {
                        Console.WriteLine("EL VALOR INGRESADO NO SE ENCUENTRA EN EL ARREGLO");
                    } else {
                        Console.WriteLine($"EL VALOR: {valor} SE ENCUENTRA EN LA POSICION: {posicion}");
                    }
                    break;

                case 4:
                    Console.WriteLine("======= RECORRIDO INVERSO EN ARREGLOS =======");
                    for (int i = 3; i >= 0; i--) {
                        Console.Write(ar4[i]);
                    }
                    Console.WriteLine();
                    break;
            }

            Console.WriteLine("DESEA REALIZAR OTRA OPERACION? 1) SI o 2) NO");
            resp = int.Parse(Console.ReadLine());

        } while (resp != 2);
    }
}
