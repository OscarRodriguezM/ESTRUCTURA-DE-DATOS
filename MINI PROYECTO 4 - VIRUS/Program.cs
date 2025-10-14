using System;

class Program
{
    static void Main()
    {
        char[,] matriz = new char[20, 20];
        int movX = 5;
        int movY = 5;

        // MOVIMIENTO DEL JUGADOR FUNCIONA ASI:
        // ARRIBA = X-1     W   (-1, 0)
        // ABAJO = X+1      S   (+1, 0)
        // IZQUIERDA = Y-1  A   (0, -1)
        // DERECHA = Y+1    D   (0, +1)

        matriz[0, 0] = 'V'; // VIRUS EN ROJO
        matriz[0, 1] = 'B'; // BARRERA EN CAFE
        matriz[5, 5] = 'P'; // JUGADOR EN MORADO
        matriz[0, 3] = 'S'; // SALIDA EN VERDE

        // MOSTRAR EL TABLERO DEL JUEGO
        Console.WriteLine("     ======= TABLERO DEL JUEGO =======");
        Console.WriteLine("┌─────────────────────────────────────────┐");

        for (int i = 0; i < 20; i++)
        {
            Console.Write("│ ");
            for (int j = 0; j < 20; j++)
            {
                switch (matriz[i, j])
                {
                    case 'V':
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("V ");
                        Console.ResetColor();
                        break;
                    case 'B':
                        Console.ForegroundColor = ConsoleColor.DarkYellow;
                        Console.Write("B ");
                        Console.ResetColor();
                        break;
                    case 'P':
                        Console.ForegroundColor = ConsoleColor.Magenta;
                        Console.Write("P ");
                        Console.ResetColor();
                        break;

                    case 'S':
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.Write("S ");
                        Console.ResetColor();
                        break;
                    default:
                        Console.Write("  ");
                        break;
                }

            }
            Console.WriteLine("│");
        }

        Console.WriteLine("└─────────────────────────────────────────┘");
        Console.ForegroundColor = ConsoleColor.Red;
        Console.Write('V');
        Console.ResetColor();
        Console.Write(": Virus");
        Console.ForegroundColor = ConsoleColor.DarkYellow;
        Console.Write(" B");
        Console.ResetColor();
        Console.Write(": Barrera");
        Console.ForegroundColor = ConsoleColor.Magenta;
        Console.Write(" P");
        Console.ResetColor();
        Console.Write(": Jugador");
        Console.ForegroundColor = ConsoleColor.Green;
        Console.Write(" S");
        Console.ResetColor();
        Console.Write(": Salida");

        // MOVIMIENTO DEL JUGADOR W A S D
        // DETECTAR LA TECLA PRESIONADA
        int juegoActivo = 0;
        do
        {
            ConsoleKeyInfo movP = Console.ReadKey(true);
            int nuevaX = movX;
            int nuevaY = movY;

            switch (movP.Key)
            {
                case ConsoleKey.W:
                    if (nuevaX > 0)
                    {
                        nuevaX = nuevaX - 1;
                        matriz[movX, movY] = ' ';
                        matriz[nuevaX, nuevaY] = 'P';
                        movX = nuevaX;
                        movY = nuevaY;
                    }
                    break;
                case ConsoleKey.S:
                    if (nuevaX < 19)
                    {
                        nuevaX = nuevaX + 1;
                        matriz[movX, movY] = ' ';
                        matriz[nuevaX, nuevaY] = 'P';
                        movX = nuevaX;
                        movY = nuevaY;
                    }
                    break;
                case ConsoleKey.A:
                    if (nuevaY > 0)
                    {
                        nuevaY = nuevaY - 1;
                        matriz[movX, movY] = ' ';
                        matriz[nuevaX, nuevaY] = 'P';
                        movX = nuevaX;
                        movY = nuevaY;
                    }
                    break;
                case ConsoleKey.D:
                    if (nuevaY < 19)
                    {
                        nuevaY = nuevaY + 1;
                        matriz[movX, movY] = ' ';
                        matriz[nuevaX, nuevaY] = 'P';
                        movX = nuevaX;
                        movY = nuevaY;
                    }
                    break;

            }
            Console.Clear();

            // MOSTRAR EL TABLERO DEL JUEGO
            Console.WriteLine("     ======= TABLERO DEL JUEGO =======");
            Console.WriteLine("┌─────────────────────────────────────────┐");

            for (int i = 0; i < 20; i++)
            {
                Console.Write("│ ");
                for (int j = 0; j < 20; j++)
                {
                    switch (matriz[i, j])
                    {
                        case 'V':
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("V ");
                            Console.ResetColor();
                            break;
                        case 'B':
                            Console.ForegroundColor = ConsoleColor.DarkYellow;
                            Console.Write("B ");
                            Console.ResetColor();
                            break;
                        case 'P':
                            Console.ForegroundColor = ConsoleColor.Magenta;
                            Console.Write("P ");
                            Console.ResetColor();
                            break;

                        case 'S':
                            Console.ForegroundColor = ConsoleColor.Green;
                            Console.Write("S ");
                            Console.ResetColor();
                            break;
                        default:
                            Console.Write("  ");
                            break;
                    }

                }
                Console.WriteLine("│");
            }

            Console.WriteLine("└─────────────────────────────────────────┘");
            Console.ForegroundColor = ConsoleColor.Red;
            Console.Write('V');
            Console.ResetColor();
            Console.Write(": Virus");
            Console.ForegroundColor = ConsoleColor.DarkYellow;
            Console.Write(" B");
            Console.ResetColor();
            Console.Write(": Barrera");
            Console.ForegroundColor = ConsoleColor.Magenta;
            Console.Write(" P");
            Console.ResetColor();
            Console.Write(": Jugador");
            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write(" S");
            Console.ResetColor();
            Console.Write(": Salida");



        } while (juegoActivo < 1);
    }


}