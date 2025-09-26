#include <iostream>

using namespace std;
int main() {
    int ar1[4]; //FORMA COMUN DE DECLARAR LOS ARREGLOS, LES ASIGNO UN TAMAÑO Y LISTO
    char ar2[4];
    float ar3[4];
    int ar4[4]={1,2,3,4}; //LES ASIGNO UN TAMAÑO Y VALORES YA INICIALIZADOS O LLENADO
    char ar5[4]={'a','b','c','d'};
    float ar6[4]={2.4f,3.0f,23.0f,6.0f};
    int *arr = new int[4]; //ESTA FORMA NO LA ENTIENDO MUY BIEN, ARREGLO DINAMICO. ME FALTA APRENDERLA
    cout << "PRACTICA NO.1 DECLARACION E INICIALIZACION DE ARREGLOS EN C++" << endl;
    return 0;
}
