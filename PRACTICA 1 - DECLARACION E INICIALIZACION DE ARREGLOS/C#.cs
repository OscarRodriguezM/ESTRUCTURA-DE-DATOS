using System;

class Program {
    static void Main() {
        // FORMA COMUN DE DECLARAR LOS ARREGLOS, LES ASIGNO UN TAMAÑO Y LISTO
        int[] ar1 = new int[4];
        char[] ar2 = new char[4];
        float[] ar3 = new float[4];

        // LES ASIGNO UN TAMAÑO Y VALORES YA INICIALIZADOS O LLENADO
        int[] ar4 = {1, 2, 3, 4};
        char[] ar5 = {'a', 'b', 'c', 'd'};
        float[] ar6 = {2.4f, 3.0f, 23.0f, 6.0f};

        // ESTA FORMA NO LA ENTIENDO MUY BIEN, ARREGLO DINAMICO
        int[] arr = new int[4];

        Console.WriteLine("PRACTICA NO.1 DECLARACION E INICIALIZACION DE ARREGLOS EN C#");
    }
}