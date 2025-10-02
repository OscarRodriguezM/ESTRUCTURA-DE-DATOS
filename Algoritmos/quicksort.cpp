#include<iostream>
using namespace std;

int main(){
    int array[10] = {5,6,7,8,4,3,2,1,9,10};
    
    cout << "======= ALGORITMO DE ORDENAMIENTO QUICKSORT ======" << endl;
    cout << "ARREGLO ANTES DE QUICKSORT: " << endl;
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    // QUICKSORT COMPLETO - USANDO STACK PARA SIMULAR RECURSION
    int stack[20]; // STACK PARA GUARDAR LOS LIMITES
    int top = -1;
    
    // EMPUJAR LIMITES INICIALES
    stack[++top] = 0;   // INICIO
    stack[++top] = 9;   // FIN

    while(top >= 0) {
        // POP DE LOS LIMITES
        int fin = stack[top--];
        int inicio = stack[top--];
        
        // PARTICIÓN DEL ARRAY
        int i = inicio;
        int j = fin;
        int pivote = array[inicio]; // PIVOTE COMO PRIMER ELEMENTO
        int aux;
        
        while(i < j){
            // BUSCAR ELEMENTO MAYOR AL PIVOTE POR LA IZQUIERDA
            while(array[i] <= pivote && i < j){
                i++;
            }
            // BUSCAR ELEMENTO MENOR O IGUAL AL PIVOTE POR LA DERECHA
            while(array[j] > pivote){
                j--;
            }
            // INTERCAMBIAR ELEMENTOS SI LOS INDICES NO SE HAN CRUZADO
            if(i < j){
                aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }
        
        // COLOCAR EL PIVOTE EN SU POSICION CORRECTA
        array[inicio] = array[j];
        array[j] = pivote;
        
        // EMPUJAR SUBARRAY IZQUIERDO AL STACK SI TIENE MAS DE 1 ELEMENTO
        if(j - 1 > inicio) {
            stack[++top] = inicio;
            stack[++top] = j - 1;
        }
        // EMPUJAR SUBARRAY DERECHO AL STACK SI TIENE MAS DE 1 ELEMENTO
        if(j + 1 < fin) {
            stack[++top] = j + 1;
            stack[++top] = fin;
        }
    }

    cout << "ARREGLO DESPUES DE QUICKSORT: " << endl;
    for(int i = 0; i < 10; i++){
        cout << array[i] << " ";
    }
    cout << endl;

    return 0;
}