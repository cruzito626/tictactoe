package model;


public interface ITicTacToe {
    void create();              // vacia el tablero para iniciar un juego
    boolean markMove(int row, int column); // marca en el tablero X o O segun el que le toque
    boolean checkTicTacToe();   // despues de una jugada hay un tres en raya?
    char winner();              // devuelve 'X' cuando gana X, 'O' cuando gana 'O'
    boolean draw();             // devuelve true cuando hay empate false en caso contrario
    char[][] getBoard();        // devuelve en un arreglo el contenido de la tabla
                                // la  tabla puede contener un 'X', un 'O' o ''
}