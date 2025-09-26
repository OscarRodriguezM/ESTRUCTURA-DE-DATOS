#include <iostream>

using namespace std;
char verificarGanador(char gato[3][3])
{
    // CICLO FOR PARA REVISAR FILAS Y COLUMNAS PARA DETECTAR CUANDO
    for (int i = 0; i < 3; i++)
    {
        // CONDICION PARA LAS FILAS
        if (gato[i][0] != ' ' && gato[i][0] == gato[i][1] && gato[i][1] == gato[i][2])
            return gato[i][0];
        // CONDICION PARA LAS COLUMNAS
        if (gato[0][i] != ' ' && gato[0][i] == gato[1][i] && gato[1][i] == gato[2][i])
            return gato[0][i];
    }
    // VERIFICAR LAS DIAGONALES PRINCIPALES
    if (gato[0][0] != ' ' && gato[0][0] == gato[1][1] && gato[1][1] == gato[2][2])
        return gato[0][0];
    // VERIFICA LAS DIAGONALES SECUNDARIAS
    if (gato[0][2] != ' ' && gato[0][2] == gato[1][1] && gato[1][1] == gato[2][0])
        return gato[0][2];
    // NADIE HA HAGANADO TODAVIA
    return ' ';
}
int main()
{
    char gato[3][3];
    char p1, p2;
    int resp;
    int fila, col, turno;
    do
    {
        cout << "======= JUEGO DEL GATO =======" << endl;
        cout << "INGRESE EL SIMBOLO DEL JUGADOR 1 (X/O): ";
        cin >> p1;
        cout << "INGRESE EL SIMBOLO DEL JUGADOR 2 (X/O): ";
        cin >> p2;
        while (p1 == p2)
        {
            cout << "SIMBOLOS INVALIDOS. INGRESE NUEVAMENTE." << endl;
            cout << "INGRESE EL SIMBOLO DEL JUGADOR 1 (X/O): ";
            cin >> p1;
            cout << "INGRESE EL SIMBOLO DEL JUGADOR 2 (X/O): ";
            cin >> p2;
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                gato[i][j] = ' ';
            }
        }
        turno = 1;
        bool hayGanador = false;
        do
        {
            cout << "SIMBOLOS ASIGNADOS: JUGADOR 1 = " << p1 << ", JUGADOR 2 = " << p2 << endl;
            cout << "TURNO: " << turno << " JUGADOR 1: INGRESE LA FILA" << endl;
            cin >> fila;
            cout << "JUGADOR 1: INGRESE LA COLUMNA" << endl;
            cin >> col;

            if (gato[fila][col] == ' ')
            {
                gato[fila][col] = p1;
            }
            else
            {
                do
                {
                    cout << "CASILLA OCUPADA. INGRESE NUEVAMENTE." << endl;
                    cout << "JUGADOR 1: INGRESE LA FILA" << endl;
                    cin >> fila;
                    cout << "JUGADOR 1: INGRESE LA COLUMNA" << endl;
                    cin >> col;
                } while (gato[fila][col] != ' ');
                gato[fila][col] = p1;
            }

            cout << "ESTADO ACTUAL DEL GATO:" << endl;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    cout << "|" << gato[i][j] << "|";
                }
                cout << endl;
            }
            if (verificarGanador(gato) == p1)
            {
                cout << "¡EL JUGADOR 1: " << p1 << " HA GANADO EL JUEGO" << endl;
                hayGanador = true;
                break;
            }
            turno = turno + 1;
            if (turno > 9) break; // Si ya se llenaron los 9 espacios, salir

            cout << "TURNO: " << turno << " JUGADOR 2: INGRESE LA FILA" << endl;
            cin >> fila;
            cout << "JUGADOR 2: INGRESE LA COLUMNA" << endl;
            cin >> col;
            if (gato[fila][col] == ' ')
            {
                gato[fila][col] = p2;
            }
            else
            {
                do
                {
                    cout << "CASILLA OCUPADA. INGRESE NUEVAMENTE." << endl;
                    cout << "JUGADOR 2: INGRESE LA FILA" << endl;
                    cin >> fila;
                    cout << "JUGADOR 2: INGRESE LA COLUMNA" << endl;
                    cin >> col;
                } while (gato[fila][col] != ' ');
                gato[fila][col] = p2;
            }

            if (verificarGanador(gato) == p2)
            {
                cout << "EL JUGADOR 2:" << p2 << " HA GANADO EL JUEGO" << endl;
                hayGanador = true;
                break;
            }
            turno = turno + 1;
            cout << "ESTADO ACTUAL DEL GATO:" << endl;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    cout << "|" << gato[i][j] << "|";
                }
                cout << endl;
            }
        } while (turno <= 9);

        if (!hayGanador)
        {
            cout << "EMPATEEE" << endl;
        }

        cout << "DESEA JUGAR NUEVAMENTE? (1=SI, 2=NO): ";
        cin >> resp;
    } while (resp != 2);
}
