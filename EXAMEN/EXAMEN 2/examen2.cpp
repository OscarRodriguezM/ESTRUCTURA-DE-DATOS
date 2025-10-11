#include <iostream>

using namespace std;

int main()
{
    int matriz[3][3];
    int acum;
    int n;
    cout << "INGRESE EL TAMANO QUE TENDRA EL ARRAY: ";
    cin >> n;
    int arr[n];

    for (int i = 0; i < n; i++)
    {
        cout << "INGRESE EL ELEMENTO: " << i + 1 << endl;
        cin >> arr[i];
    }

    for (int i = 0; i < n; i++)
    {
        if (arr[i] == arr[i + 1])
        {
            arr[i]=0;
        }
    }



    cout << endl;
}