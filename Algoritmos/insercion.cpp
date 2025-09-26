#include <iostream>

using namespace std;

int main()
{
    int n, i, j, elemento;
    cout << "======= METODO DE ORDENAMIENTO POR INSERCION =======" << endl;

    cout << "INGRESE EL TAMAÑO QUE TENDRA EL ARRAY: ";
    cin >> n;

    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cout << "INGRESE EL ELEMENTO: " << i + 1 << endl;
        cin >> arr[i];
    }

for (i = 1; i < n; i++) {
    elemento = arr[i]; //ESTE ES EL ELEMENTO A INSERTAR
    j = i - 1; //ESTE ES EL INDICE DEL ELEMENTO ANTERIOR
    while (j >= 0 && arr[j] > elemento) { //COMPARA SI EL ELEMENTO ANTERIOR ES MAYOR AL ELEMENTO A INSERTAR
        arr[j + 1] = arr[j]; //SI ES ASI, MUEVE EL ELEMENTO UNA POSICION A LA DERECHA
        j--; //Y SE MUEVE AL SIGUIENTE ELEMENTO
    }
    arr[j + 1] = elemento; //CUANDO ENCUENTRA LA POSICION CORRECTA, INSERTA EL ELEMENTO
}

    cout << "ARRAY ORDENADO: " << endl;
    for (int i = 0; i < n; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}