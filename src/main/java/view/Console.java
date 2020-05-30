package view;

import model.ITicTacToe;
import model.TicTacToe;

import java.util.Scanner;

public class Console implements Gui {

    private ITicTacToe game;
    final static int NEW = 1;
    final static int CONTINUE = 2;
    final static int EXIT = 3;

    public Console(ITicTacToe game) {
        this.game = game;
    }

    public Console() {}

    @Override
    public void run() {
        int opcion;

        System.out.println("Inicio el juego");
        showOptions();
        drawBoard();
        opcion = readOption();
        while (opcion != EXIT) {
            switch (opcion) {
                case NEW:
                    setGame(new TicTacToe());
                    drawBoard();
                    showOptions();
                    break;
                case CONTINUE:
                    int row, col;
                    //showTurnPlayer();
                    drawBoard();

                    if (game.draw()) {
                        System.out.println("Empate");
                    } else if (game.checkTicTacToe()) {
                        System.out.printf("Ganador: %c%n", game.winner());
                    } else {
                        do {
                            row =  readPosition();
                            col =  readPosition();
                        } while (!game.markMove(row,col));
                        drawBoard();
                    }

                    showOptions();
                    break;
            }
            opcion = readOption();
        }
    }

    public void setGame(ITicTacToe game) {
        this.game = game;
    }

    private void drawBoard() {
        char [][] board = game.getBoard();
        System.out.printf("%C|%C|%C\n", board[0][0], board[0][1], board[0][2]);
        System.out.printf("%C|%C|%C\n", board[1][0], board[1][1], board[1][2]);
        System.out.printf("%C|%C|%C\n", board[2][0], board[2][1], board[2][2]);
    }

    private void showOptions() {
        System.out.println("------------------");
        System.out.println("Escoja Una Opcion");
        System.out.println("1.- Nueva Partida");
        System.out.println("2.- Hacer Jugada");
        System.out.println("3.- Salir");
        System.out.println("------------------");
    }

    public void showError(String error){
        System.err.printf("Error de %s%n", error);
    }

    public void showInput(String message) {
        System.out.printf("Ingrese %s:", message);
    }

/*
    public void showTurnPlayer() {
        System.out.printf("Turno de jugador %C%n", game.playerTurn());
    }
*/

    private int readNumber(String message) {
        showInput(message);
        Scanner reader = new Scanner(System.in);
        try {
            return reader.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    private int readOption() {
        String message = "opcion";
        int option = readNumber(message);
        if (!validateNumber(option,1,3)) {
            showOptions();
            showError(message);
            readOption();
        }
        return option;
    }

    private int readPosition() {
        String coordinate = "coordenada";
        int option = readNumber(coordinate);
        if (!validateNumber(option,0,2)) {
            showOptions();
            showError(coordinate);
            readPosition();
        }
        return option;
    }

    public boolean validateNumber(int option, int start, int end) {
        return option >= start && option <= end;
    }
}
