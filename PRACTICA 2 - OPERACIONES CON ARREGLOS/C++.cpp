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
    
    int resp=1;
    int menu;
    int valor;
    int n=4;
    int posicion=-1;
    cout << "PRACTICA NO.2 OPERACIONES CON ARREGLOS EN C++" << endl;
    do{
        cout<<"======= MENU DE OPERACIONES CON ARRELGOS ======="<<endl;
        cout<<"1) RECORRIDO"<<endl;
        cout<<"2) INSERCION"<<endl;
        cout<<"3) BUSQUEDA"<<endl;
        cout<<"4) RECORRIDO INVERSO"<<endl;
        cin>>menu;
        
        switch(menu){
            case 1:
            cout<<"======= RECORRIDO EN ARREGLO ======="<<endl;
            for (int i = 0; i <= 3; i++) {
            cout<<ar4[i];
            }
            cout<<endl;
            break;
            
            case 2:
            cout<<"======= INSERCION EN EL INDICE ======="<<endl;
            cout<<"INGRESE EL VALOR QUE DESEA INSERTAR"<<endl;
            cin>>valor;
        
            cout<<"ARREGLO ANTES DE LA INSERCION:"<<endl;
            for (int i = 0; i <= 3; i++) {
            cout<<ar4[i];
            }
            cout<<endl;
            
            for (int i= n; i>0; i--)
            {
                ar4[i]=ar4[i-1];
            }
            ar4[0]=valor;
            n++;
            
            cout<<"ARREGLO DESPUES DE LA INSERCION:"<<endl;
            for (int i = 0; i <= 3; i++) {
            cout<<ar4[i];
            }
            cout<<endl;
            break;
            
            case 3:
            cout<<"======= BUSQUEDA EN ARREGLOS ======="<<endl;
            cout<<"INGRESE EL VALOR QUE DESEA BUSCAR:"<<endl;
            cin>>valor;
            for (int i=0; i<=3; i++){
                if (ar4[i]==valor){
                    posicion=i;
                    break;
                }
            }
             for (int i = 0; i <= 3; i++) {
            cout<<ar4[i];
            }
            cout<<endl;
            if (posicion==-1){
                cout<<"EL VALOR INGRESADO NO SE ENCUENTRA EN EL ARREGLO"<<endl;
            }
            else{
                cout<<"EL VALOR: "<<valor<<" SE ENCUENTRA EN LA POSISCION: "<<posicion<<endl;
            }
            break;
            
            case 4:
            cout<<"======= RECORRIDO INVERSO EN ARREGLOS ======="<<endl;
            for (int i=3; i>=0; i--){
                cout<<ar4[i];
            }
            break;
            cout<<endl;
        }
        
        cout<<"DESEA REALIZAR OTRA OPERACION? 1) SI o 2) NO"<<endl;
        cin>>resp;
        
    } while(resp!=2);
    return 0;
}
