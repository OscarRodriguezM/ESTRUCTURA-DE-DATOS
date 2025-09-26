import java.util.Scanner;

public class JAVA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ar1 = new int[4];
        char[] ar2 = new char[4];
        float[] ar3 = new float[4];
        int[] ar4 = {1, 2, 3, 4};
        char[] ar5 = {'a', 'b', 'c', 'd'};
        float[] ar6 = {2.4f, 3.0f, 23.0f, 6.0f};
        int[] arr = new int[4];

        int resp = 1, n = 4, posicion = -1, valor, menu;

        System.out.println("PRACTICA NO.2 OPERACIONES CON ARREGLOS EN JAVA");

        do {
            System.out.println("======= MENU DE OPERACIONES CON ARREGLOS =======");
            System.out.println("1) RECORRIDO");
            System.out.println("2) INSERCION");
            System.out.println("3) BUSQUEDA");
            System.out.println("4) RECORRIDO INVERSO");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("======= RECORRIDO EN ARREGLO =======");
                    for (int i = 0; i < 4; i++) {
                        System.out.print(ar4[i]);
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("======= INSERCION EN EL INDICE =======");
                    System.out.println("INGRESE EL VALOR QUE DESEA INSERTAR:");
                    valor = sc.nextInt();

                    System.out.println("ARREGLO ANTES DE LA INSERCION:");
                    for (int i = 0; i < 4; i++) {
                        System.out.print(ar4[i]);
                    }
                    System.out.println();

                    for (int i = n - 1; i > 0; i--) {
                        ar4[i] = ar4[i - 1];
                    }
                    ar4[0] = valor;

                    System.out.println("ARREGLO DESPUES DE LA INSERCION:");
                    for (int i = 0; i < 4; i++) {
                        System.out.print(ar4[i]);
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println("======= BUSQUEDA EN ARREGLOS =======");
                    System.out.println("INGRESE EL VALOR QUE DESEA BUSCAR:");
                    valor = sc.nextInt();
                    posicion = -1;

                    for (int i = 0; i < 4; i++) {
                        if (ar4[i] == valor) {
                            posicion = i;
                            break;
                        }
                    }

                    for (int i = 0; i < 4; i++) {
                        System.out.print(ar4[i]);
                    }
                    System.out.println();

                    if (posicion == -1) {
                        System.out.println("EL VALOR INGRESADO NO SE ENCUENTRA EN EL ARREGLO");
                    } else {
                        System.out.println("EL VALOR: " + valor + " SE ENCUENTRA EN LA POSICION: " + posicion);
                    }
                    break;

                case 4:
                    System.out.println("======= RECORRIDO INVERSO EN ARREGLOS =======");
                    for (int i = 3; i >= 0; i--) {
                        System.out.print(ar4[i]);
                    }
                    System.out.println();
                    break;
            }

            System.out.println("DESEA REALIZAR OTRA OPERACION? 1) SI o 2) NO");
            resp = sc.nextInt();

        } while (resp != 2);
    }
}
