// Declaración e inicialización de matriz 3x3
let matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];

console.log("======= DECLARACION, INICIALIZACION Y RECORRIDO EN MATRIZ 3X3 =======");
for (let i = 0; i <= 2; i++) {
    let fila = "";
    for (let j = 0; j <= 2; j++) {
        fila += matriz[i][j];
    }
    console.log(fila);
}

console.log("RECORRIDO INVERSO EN UNA MATRIZ 3X3");
for (let i = 2; i >= 0; i--) {
    let fila = "";
    for (let j = 2; j >= 0; j--) {
        fila += matriz[i][j];
    }
    console.log(fila);
}
