#include <iostream>

using namespace std;
int main()
{
    
    int matriz[3][3] = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9}
    };
    cout<<"======= DECLARACION, INICIALIZACION Y RECORRIDO EN MATRIZ 3X3"<<endl;
    for(int i=0; i<=2; i++){
        for(int j=0; j<=2; j++){
            cout<<matriz[i][j];
        }
        cout<<endl;
    }
    
    cout<<"RECORRIDO INVERSO EN UNA MATRIZ 3X3"<<endl;
    for(int i=2; i>=0; i--){
        for(int j=2; j>=0; j--){
            cout<<matriz[i][j];
        }
        cout<<endl;
    }
    return 0;
}
