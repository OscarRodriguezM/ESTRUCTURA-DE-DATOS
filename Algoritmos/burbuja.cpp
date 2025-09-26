#include <iostream>

using namespace std;

int main(){

    cout<<"======= METODO DE ORDENAMIENTO BURBUJA ======="<<endl;

    int n;
    cout<<"INGRESE EL TAMAÑO QUE TENDRA EL ARRAY: ";
    cin>>n;

    int arr[n];
    
    for(int i=0; i<n; i++){
        cout<<"INGRESE EL ELEMENTO: "<<i+1<<endl;
        cin>>arr[i];
    }

    //AQUI EMPIEZA EL ALGORITMO DE ORDENAMIENTO BURBUJA
    for(int i=0; i<n-1; i++){
        for(int j=0; j<n-i-1; j++){
            if(arr[j] > arr[j+1]){ //COMPARA SI EL ELEMENTO ACTUAL ES MAYOR AL SIGUIENTE
                //AQUI INTERCAMBIA LOS ELEMENTOS
                int temp = arr[j]; //GUARDA EL VALOR ACTUAL EN UNA VARIABLE TEMPORAL
                arr[j] = arr[j+1]; //ASIGNA EL VALOR SIGUIENTE AL ACTUAL
                arr[j+1] = temp; //ASIGNA EL VALOR TEMPORAL AL SIGUIENTE 
            }
        }
    }

    cout<<"ARRAY ORDENADO: "<<endl;
    for(int i=0; i<n; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;

    return 0;
}