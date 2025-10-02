#include<iostream>
using namespace std;

int main(){
    int array[10] = {5,6,7,8,4,3,2,1,9,10};
    int n = 10;
    
    cout << "======= ALGORITMO DE ORDENAMIENTO HEAPSORT ======" << endl;
    cout << "ARREGLO ANTES DE ORDENAR: ";
    for(int i = 0; i < n; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    // CONSTRUIR EL MAX-HEAP
    cout << "======= CONSTRUYENDO MAX-HEAP =======" << endl;
    for(int i = n / 2 - 1; i >= 0; i--){
        int indice_actual = i;
        
        // AJUSTAR EL SUB-HEAP
        while(true){
            int indice_maximo = indice_actual;
            int hijo_izquierdo = 2 * indice_actual + 1;
            int hijo_derecho = 2 * indice_actual + 2;
            
            // COMPARAR CON HIJO IZQUIERDO
            if(hijo_izquierdo < n && array[hijo_izquierdo] > array[indice_maximo]){
                indice_maximo = hijo_izquierdo;
            }
            
            // COMPARAR CON HIJO DERECHO
            if(hijo_derecho < n && array[hijo_derecho] > array[indice_maximo]){
                indice_maximo = hijo_derecho;
            }
            
            // SI EL MAXIMO NO ES EL PADRE, INTERCAMBIAR
            if(indice_maximo != indice_actual){
                int temp = array[indice_actual];
                array[indice_actual] = array[indice_maximo];
                array[indice_maximo] = temp;
                
                indice_actual = indice_maximo;
            } else {
                break;
            }
        }
        
        // MOSTRAR ESTADO DESPUES DE CADA AJUSTE
        cout << "DESPUES DE AJUSTAR EL INDICE " << i << ": ";
        for(int j = 0; j < n; j++) cout << array[j] << " ";
        cout << endl;
    }
    
    cout << "MAX-HEAP CONSTRUIDO: ";
    for(int i = 0; i < n; i++) cout << array[i] << " ";
    cout << endl;

    // EXTRAER ELEMENTOS UNO POR UNO DEL HEAP
    cout << "======= EXTRAYENDO ELEMENTOS DEL HEAP =======" << endl;
    for(int tamano_heap = n - 1; tamano_heap > 0; tamano_heap--){
        // MOVER LA RAIZ (MAXIMO) AL FINAL
        int temp = array[0];
        array[0] = array[tamano_heap];
        array[tamano_heap] = temp;
        
        // AJUSTAR EL HEAP REDUCIDO
        int indice_actual = 0;
        
        while(true){
            int indice_maximo = indice_actual;
            int hijo_izquierdo = 2 * indice_actual + 1;
            int hijo_derecho = 2 * indice_actual + 2;
            
            // COMPARAR CON HIJO IZQUIERDO (DENTRO DEL HEAP)
            if(hijo_izquierdo < tamano_heap && array[hijo_izquierdo] > array[indice_maximo]){
                indice_maximo = hijo_izquierdo;
            }
            
            // COMPARAR CON HIJO DERECHO (DENTRO DEL HEAP)
            if(hijo_derecho < tamano_heap && array[hijo_derecho] > array[indice_maximo]){
                indice_maximo = hijo_derecho;
            }
            
            // SI EL MAXIMO NO ES EL PADRE, INTERCAMBIAR
            if(indice_maximo != indice_actual){
                int temp = array[indice_actual];
                array[indice_actual] = array[indice_maximo];
                array[indice_maximo] = temp;
                
                indice_actual = indice_maximo;
            } else {
                break;
            }
        }
        
        // MOSTRAR PROGRESO
        cout << "Extraido " << array[tamano_heap] << ": ";
        for(int j = 0; j < n; j++) cout << array[j] << " ";
        cout << endl;
    }

    cout << "ARREGLO DESPUES DE HEAPSORT: ";
    for(int i = 0; i < n; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    return 0;
}