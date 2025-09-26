const prompt = require("prompt-sync")();

let ar1 = new Array(4);
let ar2 = new Array(4);
let ar3 = new Array(4);
let ar4 = [1, 2, 3, 4];
let ar5 = ['a', 'b', 'c', 'd'];
let ar6 = [2.4, 3.0, 23.0, 6.0];
let arr = new Array(4);

let resp = 1;
let n = 4;
let posicion = -1;

console.log("PRACTICA NO.2 OPERACIONES CON ARREGLOS EN JAVASCRIPT");

while (resp != 2) {
    console.log("======= MENU DE OPERACIONES CON ARREGLOS =======");
    console.log("1) RECORRIDO");
    console.log("2) INSERCION");
    console.log("3) BUSQUEDA");
    console.log("4) RECORRIDO INVERSO");
    let menu = parseInt(prompt(""));

    switch (menu) {
        case 1:
            console.log("======= RECORRIDO EN ARREGLO =======");
            console.log(ar4.join(""));
            break;

        case 2:
            console.log("======= INSERCION EN EL INDICE =======");
            let valor = parseInt(prompt("INGRESE EL VALOR QUE DESEA INSERTAR: "));

            console.log("ARREGLO ANTES DE LA INSERCION:");
            console.log(ar4.join(""));

            for (let i = n - 1; i > 0; i--) {
                ar4[i] = ar4[i - 1];
            }
            ar4[0] = valor;

            console.log("ARREGLO DESPUES DE LA INSERCION:");
            console.log(ar4.join(""));
            break;

        case 3:
            console.log("======= BUSQUEDA EN ARREGLOS =======");
            valor = parseInt(prompt("INGRESE EL VALOR QUE DESEA BUSCAR: "));
            posicion = -1;

            for (let i = 0; i < 4; i++) {
                if (ar4[i] === valor) {
                    posicion = i;
                    break;
                }
            }

            console.log(ar4.join(""));

            if (posicion === -1) {
                console.log("EL VALOR INGRESADO NO SE ENCUENTRA EN EL ARREGLO");
            } else {
                console.log(`EL VALOR: ${valor} SE ENCUENTRA EN LA POSICION: ${posicion}`);
            }
            break;

        case 4:
            console.log("======= RECORRIDO INVERSO EN ARREGLOS =======");
            console.log(ar4.slice().reverse().join(""));
            break;
    }

    resp = parseInt(prompt("DESEA REALIZAR OTRA OPERACION? 1) SI o 2) NO: "));
}
