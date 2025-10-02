#include<iostream>
using namespace std;

int main(){
    int array[10] = {5,6,7,8,4,3,2,1,9,10};
    
    cout << "======= ALGORITMO DE ORDENAMIENTO SELECTION SORT ======" << endl;
    cout << "ARREGLO ANTES DE ORDENAR: " << endl;
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    // ALGORITMO SELECTION SORT
    for(int i = 0; i < 9; i++){
        // ENCONTRAR LA POSICION DEL ELEMENTO MAS PEQUEÑO
        int posicion_menor = i;
        
        for(int j = i + 1; j < 10; j++){
            if(array[j] < array[posicion_menor]){
                posicion_menor = j;
            }
        }
        
        // INTERCAMBIAR EL ELEMENTO MAS PEQUEÑO CON LA POSICION ACTUAL
        if(posicion_menor != i){
            int temp = array[i];
            array[i] = array[posicion_menor];
            array[posicion_menor] = temp;
        }
        
    }

    cout << "ARREGLO DESPUES DE SELECTION SORT: " << endl;
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    return 0;
}