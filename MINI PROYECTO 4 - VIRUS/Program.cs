using System;

class Program
{
    static void Main()
    {
        char[,] matriz = new char[20, 20];

        matriz[0, 0] = 'V'; // VIRUS EN ROJO
        matriz[0, 1] = 'B'; // BARRERA EN CAFE
        matriz[0, 2] = 'P'; // JUGADOR EN MORADO
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
                        Console.Write("□ ");
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
    }
}