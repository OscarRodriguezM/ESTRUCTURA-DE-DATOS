
const DIFFICULTY_ORDER = ['muy_facil', 'facil', 'medio', 'dificil', 'muy_dificil'];

const DIFFICULTIES = {
    "muy_facil": { name: "MUY FACIL", min: 36, max: 49 },
    "facil":     { name: "FACIL",     min: 32, max: 35 },
    "medio":     { name: "MEDIO",     min: 28, max: 31 },
    "dificil":   { name: "DIFICIL",   min: 24, max: 27 },
    "muy_dificil":{ name: "MUY DIFICIL",min: 17, max: 23 }
};

let gameState = {
    user: "",
    currentDifficultyIndex: 0, 
    currentPuzzleIndex: 0,    
    maxLives: 3,
    currentLives: 3,
    mistakesInBatch: false,  
    timerInterval: null,
    secondsElapsed: 0
};

// ARREGLO DE 3 DIMENSIONES
let currentLevelSolutions = [];
let currentLevelGrids = [];

function generateSolvedGrid() {
    let grid = Array.from({ length: 9 }, () => Array(9).fill(0));
    fillGrid(grid);
    return grid;
}

function fillGrid(grid) {
    for (let row = 0; row < 9; row++) {
        for (let col = 0; col < 9; col++) {
            if (grid[row][col] === 0) {
                let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9].sort(() => Math.random() - 0.5);
                for (let num of numbers) {
                    if (isValid(grid, row, col, num)) {
                        grid[row][col] = num;
                        if (fillGrid(grid)) return true;
                        grid[row][col] = 0;
                    }
                }
                return false;
            }
        }
    }
    return true;
}

function isValid(grid, row, col, num) {
    for (let i = 0; i < 9; i++) {
        if (grid[row][i] === num || grid[i][col] === num) return false;
    }
    let startRow = Math.floor(row / 3) * 3;
    let startCol = Math.floor(col / 3) * 3;
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if (grid[startRow + i][startCol + j] === num) return false;
        }
    }
    return true;
}

function createPuzzle(solvedGrid, difficultyKey) {
    let puzzle = JSON.parse(JSON.stringify(solvedGrid));
    let conf = DIFFICULTIES[difficultyKey];
    let cluesToLeave = Math.floor(Math.random() * (conf.max - conf.min + 1)) + conf.min;
    let cellsToDig = 81 - cluesToLeave;

    while (cellsToDig > 0) {
        let r = Math.floor(Math.random() * 9);
        let c = Math.floor(Math.random() * 9);
        if (puzzle[r][c] !== 0) {
            puzzle[r][c] = 0;
            cellsToDig--;
        }
    }
    return puzzle;
}

function startGame() {
    const usernameInput = document.getElementById('username').value;
    if (!usernameInput.trim()) { alert("¡NECESITAS UN NOMBRE!"); return; }

    gameState.user = usernameInput;
    gameState.currentDifficultyIndex = 0; 
    gameState.maxLives = 3;
    gameState.currentLives = 3;
    gameState.secondsElapsed = 0;

    document.getElementById('login-section').style.display = 'none';
    document.getElementById('game-section').style.display = 'block';
    document.getElementById('player-name').textContent = gameState.user;

    startNewDifficultyLevel();
    startTimer();
}

// Genera el lote de 5 sudokus para la dificultad actual
function startNewDifficultyLevel() {
    gameState.currentPuzzleIndex = 0;
    gameState.mistakesInBatch = false; // Reiniciamos el trackeo de errores para el bonus
    
    // Regenerar vidas al máximo al iniciar nuevo nivel de dificultad
    gameState.currentLives = gameState.maxLives;

    let diffKey = DIFFICULTY_ORDER[gameState.currentDifficultyIndex];
    let diffName = DIFFICULTIES[diffKey].name;

    // Actualizar HUD
    document.getElementById('difficulty-name').textContent = diffName;
    updateHUD();

    // Generar arreglo 3D
    currentLevelSolutions = [];
    currentLevelGrids = [];
    for (let i = 0; i < 5; i++) {
        let solved = generateSolvedGrid();
        currentLevelSolutions.push(solved);
        currentLevelGrids.push(createPuzzle(solved, diffKey));
    }

    loadPuzzle(0);
}

function loadPuzzle(index) {
    gameState.currentPuzzleIndex = index;
    updateHUD();
    renderBoard(currentLevelGrids[index]);
}

function renderBoard(grid) {
    const boardContainer = document.getElementById('sudoku-board');
    boardContainer.innerHTML = '';
    for (let row = 0; row < 9; row++) {
        for (let col = 0; col < 9; col++) {
            const cell = document.createElement('input');
            cell.type = 'number';
            cell.min = 1; cell.max = 9;
            cell.className = 'cell';
            if (row === 2 || row === 5) cell.classList.add('row-border-bottom');
            
            if (grid[row][col] !== 0) {
                cell.value = grid[row][col];
                cell.disabled = true;
                cell.classList.add('given');
            } else {
                cell.dataset.r = row;
                cell.dataset.c = col;
                cell.addEventListener('change', handleInput);
            }
            boardContainer.appendChild(cell);
        }
    }
}

function handleInput(e) {
    let val = parseInt(e.target.value);
    let r = parseInt(e.target.dataset.r);
    let c = parseInt(e.target.dataset.c);
    let correctVal = currentLevelSolutions[gameState.currentPuzzleIndex][r][c];

    if (isNaN(val)) { e.target.value = ''; return; }

    if (val === correctVal) {
        e.target.classList.add('correct');
        e.target.disabled = true;
        currentLevelGrids[gameState.currentPuzzleIndex][r][c] = val;
        checkCompletion();
    } else {
        e.target.classList.add('incorrect');
        gameState.currentLives--;
        gameState.mistakesInBatch = true; // Marcamos error en este lote de 5
        updateHUD();
        setTimeout(() => { e.target.value = ''; e.target.classList.remove('incorrect'); }, 800);

        if (gameState.currentLives <= 0) gameOver();
    }
}

function checkCompletion() {
    let currentGrid = currentLevelGrids[gameState.currentPuzzleIndex];
    for(let r=0; r<9; r++) for(let c=0; c<9; c++) if(currentGrid[r][c] === 0) return;

    // Puzzle completado
    setTimeout(() => nextPuzzle(), 300);
}

function nextPuzzle() {
    if (gameState.currentPuzzleIndex < 4) {
        // Avanzar al siguiente puzzle del MISMO nivel de dificultad
        alert(`Sudoku ${gameState.currentPuzzleIndex + 1}/5 completado.`);
        loadPuzzle(gameState.currentPuzzleIndex + 1);
    } else {
        // Se completaron los 5 sudokus de este nivel
        let diffName = DIFFICULTIES[DIFFICULTY_ORDER[gameState.currentDifficultyIndex]].name;
        let msg = `¡Nivel ${diffName} superado!`;

        // Bonus de vida si fue perfecto
        if (!gameState.mistakesInBatch) {
            gameState.maxLives++;
            msg += "\n¡Juego perfecto! Vidas máximas +1.";
        }

        if (gameState.currentDifficultyIndex < 4) {
            // Avanzar a la siguiente dificultad
            gameState.currentDifficultyIndex++;
            msg += `\nAvanzando a dificultad: ${DIFFICULTIES[DIFFICULTY_ORDER[gameState.currentDifficultyIndex]].name}`;
            alert(msg);
            startNewDifficultyLevel();
        } else {
            // Juego completado
            stopTimer();
            alert(`¡FELICIDADES! Has completado TODOS los niveles en ${formatTime(gameState.secondsElapsed)}.\nEres un verdadero maestro del Sudoku.`);
            returnToMenu();
        }
    }
}

function updateHUD() {
    document.getElementById('lives').textContent = gameState.currentLives;
    document.getElementById('max-lives').textContent = gameState.maxLives;
    document.getElementById('current-puzzle').textContent = gameState.currentPuzzleIndex + 1;
}

function gameOver() {
    stopTimer();
    alert("¡GAME OVER!\nTE QUEDASTE SIN VIDAS.");
    returnToMenu();
}

function returnToMenu() {
    stopTimer();
    document.getElementById('game-section').style.display = 'none';
    document.getElementById('login-section').style.display = 'block';
}

function startTimer() {
    stopTimer();
    gameState.timerInterval = setInterval(() => {
        gameState.secondsElapsed++;
        document.getElementById('timer').textContent = formatTime(gameState.secondsElapsed);
    }, 1000);
}

function stopTimer() { clearInterval(gameState.timerInterval); }
function formatTime(s) { return `${Math.floor(s / 60).toString().padStart(2,'0')}:${(s % 60).toString().padStart(2,'0')}`; }