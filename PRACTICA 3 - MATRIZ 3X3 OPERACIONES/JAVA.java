public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("======= DECLARACION, INICIALIZACION Y RECORRIDO EN MATRIZ 3X3 =======");
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }

        System.out.println("RECORRIDO INVERSO EN UNA MATRIZ 3X3");
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}
