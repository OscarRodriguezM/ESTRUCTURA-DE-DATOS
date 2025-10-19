using System;
using System.Threading;

class Program
{
    static void Main()
    {
        int vidas = 3;
        int nivel = 1;
        int maxSalud = 3;
        Random rnd = new Random();

        Console.Clear();
        Console.CursorVisible = false;

        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine(@"
            V   V  IIIII  RRRR   U   U  SSSSS
            V   V    I    R   R  U   U  S
            V   V    I    RRRR   U   U  SSSSS
             V V     I    R  R   U   U      S
              V    IIIII  R   R   UUU   SSSSS
        ");
        Console.ForegroundColor = ConsoleColor.Gray;
        Console.WriteLine("            - PRESIONA CUALQUIER TECLA PARA CONTINUAR -"); 
        Console.ReadKey();


        // BUCLE PRINCIPAL DEL JUEGO (MIENTRAS HAYA VIDAS)
        while (vidas > 0)
        {
            // VARIABLES QUE SE REINICIAN EN CADA NIVEL
            char[,] matriz = new char[20, 20];
            int movX = 5;
            int movY = 5;
            int salud = maxSalud;

            // LÓGICA DE DIFICULTAD PROGRESIVA
            int virusAdicionales = (nivel - 1) / 3;
            int cantidadVirus = 2 + virusAdicionales;

            int reduccionVelocidad = ((nivel - 1) / 3) * 100;
            int velocidadExpansion = Math.Max(300, 1000 - reduccionVelocidad);

            int barrerasAdicionales = (nivel - 1) / 3;
            int inventarioBarreras = 3 + barrerasAdicionales;

            int inventarioAnalgesicos = 3;
            
            matriz[movX, movY] = 'P'; 
            matriz[0, 3] = 'S';

            for (int v = 0; v < cantidadVirus; v++)
            {
                int virusX, virusY;
                do
                {
                    virusX = rnd.Next(0, 20);
                    virusY = rnd.Next(0, 20); 
                } while (matriz[virusX, virusY] != '\0' || (virusX == movX && virusY == movY)); 

                matriz[virusX, virusY] = 'V';
            }
            
            Console.Clear(); 
            Console.ForegroundColor = ConsoleColor.DarkRed; 
            Console.WriteLine("     ╔═════════════════════════════════════════╗");

            for (int i = 0; i < 20; i++)
            {
                Console.Write("     ║ "); 
                Console.ResetColor(); 
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
                Console.ForegroundColor = ConsoleColor.DarkRed; 
                Console.WriteLine("║"); 
            }

            Console.WriteLine("     ╚═════════════════════════════════════════╝");
            Console.ResetColor(); 

            Console.SetCursorPosition(0, 22); 
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

            // FASE DE PREPARACIÓN (COLOCAR BARRERAS)
            Console.CursorVisible = true;
            while (inventarioBarreras > 0)
            {
                Console.ForegroundColor = ConsoleColor.DarkGray;
                Console.SetCursorPosition(0, 24);
                Console.WriteLine("╔══════════════════════════════════════════════════════════╗");
                Console.WriteLine("║                                                          ║");
                Console.WriteLine("╚══════════════════════════════════════════════════════════╝");
                
                Console.SetCursorPosition(2, 25);
                Console.ForegroundColor = ConsoleColor.White;
                Console.Write($"PREPARACIÓN: Te quedan {inventarioBarreras} barreras. ");
                Console.Write("Ingresa coordenadas (ej: 5,10) o escribe 'listo': ");
                string? entrada = Console.ReadLine(); 

                if (entrada == null) 
                {
                    continue; 
                }

                if (entrada.ToLower() == "listo")
                {
                    break;
                }

                try
                {
                    string[] coords = entrada.Split(',');
                    int fila = int.Parse(coords[0].Trim());
                    int col = int.Parse(coords[1].Trim());

                    if (fila >= 0 && fila < 20 && col >= 0 && col < 20 && matriz[fila, col] == '\0')
                    {
                        matriz[fila, col] = 'B';
                        inventarioBarreras--;
                        Console.SetCursorPosition(col * 2 + 7, fila + 2); 
                        Console.ForegroundColor = ConsoleColor.DarkYellow;
                        Console.Write("B ");
                        Console.ResetColor();
                    }
                }
                catch { /*IGNORA TECLAS INVALIDAS */ }
            }
            
            Console.SetCursorPosition(0, 24);
            Console.Write(new string(' ', Console.WindowWidth * 3)); 
            Console.SetCursorPosition(2, 25);
            Console.ForegroundColor = ConsoleColor.Green;
            Console.Write("¡Preparación completa! Presiona una tecla para empezar...");
            Console.ReadKey(true); 

            Console.CursorVisible = false;
            Console.SetCursorPosition(0, 24);
            Console.Write(new string(' ', Console.WindowWidth * 3));
            int juegoActivo = 0;
            DateTime tiempoUltimaExpansion = DateTime.Now;

            do
            {
                // UI
                Console.ForegroundColor = ConsoleColor.DarkGray;
                Console.SetCursorPosition(0, 23);
                Console.Write("╔══════════╦══════════╦═════════════════════════╦══════════╦══════════════╗");
                Console.SetCursorPosition(0, 24);
                Console.Write("║          ║          ║                         ║          ║              ║");
                Console.SetCursorPosition(0, 25);
                Console.Write("╚══════════╩══════════╩═════════════════════════╩══════════╩══════════════╝");
                Console.SetCursorPosition(2, 24); Console.ForegroundColor = ConsoleColor.White; Console.Write($"NIVEL: {nivel}");
                Console.SetCursorPosition(13, 24); Console.Write($"VIDAS: {vidas}");
                Console.SetCursorPosition(24, 24); Console.Write("SALUD: ");
                if (salud > 1) { Console.ForegroundColor = ConsoleColor.Green; }
                else { Console.ForegroundColor = ConsoleColor.Red; }
                string barraSalud = new string('█', salud * 5) + new string('░', (maxSalud - salud) * 5);
                Console.Write($"[{barraSalud}]");
                Console.SetCursorPosition(48, 24); Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write($"BARR: {inventarioBarreras}");
                Console.SetCursorPosition(59, 24); Console.ForegroundColor = ConsoleColor.Magenta; Console.Write($"ANALG: {inventarioAnalgesicos} (H)");
                Console.ResetColor();


                if (Console.KeyAvailable)
                {
                    ConsoleKeyInfo movP = Console.ReadKey(true);
                    int antiguaX = movX;
                    int antiguaY = movY;

                    switch (movP.Key)
                    {
                        case ConsoleKey.W:
                            if (movX > 0) movX--;
                            break;
                        case ConsoleKey.S:
                            if (movX < 19) movX++;
                            break;
                        case ConsoleKey.A:
                            if (movY > 0) movY--;
                            break;
                        case ConsoleKey.D:
                            if (movY < 19) movY++;
                            break;
                        case ConsoleKey.H:
                            if (inventarioAnalgesicos > 0 && salud < maxSalud)
                            {
                                salud = maxSalud;
                                inventarioAnalgesicos--;
                            }
                            continue;
                    }

                    if (antiguaX != movX || antiguaY != movY)
                    {
                        char celdaDestino = matriz[movX, movY];

                        if (celdaDestino == 'B')
                        {
                            movX = antiguaX;
                            movY = antiguaY;
                        }
                        else
                        {
                            matriz[antiguaX, antiguaY] = ' ';
                            Console.SetCursorPosition(antiguaY * 2 + 7, antiguaX + 2); 
                            Console.Write("  ");

                            Console.SetCursorPosition(movY * 2 + 7, movX + 2); 
                            Console.ForegroundColor = ConsoleColor.Magenta;
                            Console.Write("P ");
                            Console.ResetColor();

                            if (celdaDestino == 'V')
                            {
                                salud--;
                                if (salud <= 0)
                                {
                                    vidas--;
                                    juegoActivo = 1;
                                }
                            }
                            else if (celdaDestino == 'S')
                            {
                                nivel++;
                                juegoActivo = 1;
                            }

                            matriz[movX, movY] = 'P';
                        }
                    }
                }

                // EXPANSIÓN DEL VIRUS
                if ((DateTime.Now - tiempoUltimaExpansion).TotalMilliseconds > velocidadExpansion)
                {
                    char[,] nMatriz = (char[,])matriz.Clone();
                    for (int i = 0; i < 20; i++)
                    {
                        for (int j = 0; j < 20; j++)
                        {
                            if (matriz[i, j] == 'V')
                            {
                                if (i > 0 && (matriz[i - 1, j] == ' ' || matriz[i - 1, j] == '\0' || matriz[i - 1, j] == 'P'))
                                {
                                    nMatriz[i - 1, j] = 'V';
                                }
                                if (i < 19 && (matriz[i + 1, j] == ' ' || matriz[i + 1, j] == '\0' || matriz[i + 1, j] == 'P'))
                                {
                                    nMatriz[i + 1, j] = 'V';
                                }
                                if (j > 0 && (matriz[i, j - 1] == ' ' || matriz[i, j - 1] == '\0' || matriz[i, j - 1] == 'P'))
                                {
                                    nMatriz[i, j - 1] = 'V';
                                }
                                if (j < 19 && (matriz[i, j + 1] == ' ' || matriz[i, j + 1] == '\0' || matriz[i, j + 1] == 'P'))
                                {
                                    nMatriz[i, j + 1] = 'V';
                                }
                            }
                        }
                    }

                    for (int i = 0; i < 20; i++)
                    {
                        for (int j = 0; j < 20; j++)
                        {
                            if (nMatriz[i, j] == 'V' && matriz[i, j] != 'V')
                            {
                                if (i == movX && j == movY)
                                {
                                    salud--;
                                    if (salud <= 0)
                                    {
                                        vidas--;
                                        juegoActivo = 1;
                                    }
                                    matriz[i, j] = 'V';
                                }
                                else
                                {
                                    matriz[i, j] = 'V';
                                    Console.SetCursorPosition(j * 2 + 7, i + 2); 
                                    Console.ForegroundColor = ConsoleColor.Red;
                                    Console.Write("V ");
                                    Console.ResetColor();
                                }
                            }
                        }
                    }

                    tiempoUltimaExpansion = DateTime.Now;
                }

                Thread.Sleep(50);

            } while (juegoActivo < 1);

        }

        Console.SetCursorPosition(0, 27);
        Console.ForegroundColor = ConsoleColor.Red;
        Console.WriteLine("GAME OVER. SE HAN AGOTADO LAS VIDAS! ");
        Console.ResetColor();
        Console.CursorVisible = true;
    }
}