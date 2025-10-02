#include<iostream>
using namespace std;

int main(){
    int array[10] = {5,6,7,8,4,3,2,1,9,10};
    int temp[10]; // ARRAY TEMPORAL PARA EL MERGE
    
    cout << "======= ALGORITMO DE ORDENAMIENTO MERGESORT ======" << endl;
    cout << "ARREGLO ANTES DE ORDENAR: ";
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    int n = 10;
    
    // TAMANIO DE SUBARRAYS A COMBINAR (1, 2, 4, 8, ...)
    for(int tam_bloque = 1; tam_bloque < n; tam_bloque = tam_bloque * 2){
        // COMBINAR SUBARRAYS DE TAMANIO ACTUAL
        for(int inicio_left = 0; inicio_left < n; inicio_left += 2 * tam_bloque){
            int medio = inicio_left + tam_bloque - 1;
            int fin_right = inicio_left + 2 * tam_bloque - 1;
            
            // AJUSTAR FIN_RIGHT SI SE PASA DEL LIMITE
            if(fin_right >= n){
                fin_right = n - 1;
            }
            
            // SOLO COMBINAR SI HAY ELEMENTOS EN AMBOS LADOS
            if(medio >= fin_right) continue;
            
            // COPIAR LOS DOS SUBARRAYS AL ARRAY TEMPORAL
            for(int i = inicio_left; i <= fin_right; i++){
                temp[i] = array[i];
            }
            
            // COMBINAR LOS DOS SUBARRAYS ORDENADOS
            int i = inicio_left;      // INDICE PARA SUBARRAY IZQUIERDO
            int j = medio + 1;        // INDICE PARA SUBARRAY DERECHO
            int k = inicio_left;      // INDICE PARA ARRAY RESULTADO
            
            while(i <= medio && j <= fin_right){
                if(temp[i] <= temp[j]){
                    array[k] = temp[i];
                    i++;
                } else {
                    array[k] = temp[j];
                    j++;
                }
                k++;
            }
            
            // COPIAR ELEMENTOS RESTANTES DEL SUBARRAY IZQUIERDO
            while(i <= medio){
                array[k] = temp[i];
                i++;
                k++;
            }
            
            // COPIAR ELEMENTOS RESTANTES DEL SUBARRAY DERECHO
            while(j <= fin_right){
                array[k] = temp[j];
                j++;
                k++;
            }
        }
        
        // MOSTRAR PROGRESO DESPUES DE CADA PASADA
        cout << "DESPUES DE COMBINAR BLOQUES DE " << tam_bloque << ": ";
        for(int i = 0; i < 10; i++){
            cout << array[i] << " ";
        }
        cout << endl;
    }

    cout << "ARREGLO DESPUES DE MERGESORT: ";
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    return 0;
}