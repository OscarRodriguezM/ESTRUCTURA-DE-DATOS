#include <iostream>

using namespace std;

int main()
{
    int num[10];
    int contador, contimpar;
    contador=0;
    contimpar=0;
    cout<<"======= EXAMEN 1 ======="<<endl;
    for(int i=1; i<=10; i++){
        cout<<"INGRE EL NUMERO NO."<<i<<" : "<<endl;
        cin>>num[i];
    }

    for(int i=1; i<=10; i++){
        if(num[i]%2==0){
                contador=contador+1;
        } else{
            contimpar=contimpar+1;
        }
    }
    cout<<"LA CANTIDAD DE NUMEROS PAR ES: "<<contador<<endl;
    cout<<"LA CANTIDAD DE NUMEROS IMPAR ES: "<<contimpar<<endl;

    return 0;
}