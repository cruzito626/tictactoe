package view;

import model.MatrixBoard;
import model.TicTacToe;

import java.util.Scanner;

public class Console implements Gui {

    private TicTacToe game;
    final static int NEW = 1;
    final static int CONTINUE = 2;
    final static int EXIT = 3;

    public Console(TicTacToe game) {
        this.game = game;
    }

    public Console() {
        this.game = new TicTacToe(new MatrixBoard());
    }

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
                    game.restart();
                    drawBoard();
                    showOptions();
                    break;
                case CONTINUE:
                    int row, col;
                    showTurnPlayer();
                    drawBoard();
                    if (!game.isFinished()) {
                        do {
                            row =  readPosition();
                            col =  readPosition();
                        } while (!game.markCell(row,col));
                        drawBoard();
                    }
                    if (game.isFinished()) {
                        if (game.isWinningPlay()) {
                            System.out.printf("Ganador: %c%n", game.getWinner());
                            System.out.printf("Perdedor: %c%n", game.getLoser());
                        } else {
                            System.out.println("Empate");
                        }
                    }
                    showOptions();
                    break;
            }
            opcion = readOption();
        }
    }

    private void drawBoard() {
        System.out.printf("%C|%C|%C\n", game.getCell(0,0), game.getCell(0,1), game.getCell(0,2));
        System.out.printf("%C|%C|%C\n", game.getCell(1,0), game.getCell(1,1), game.getCell(1,2));
        System.out.printf("%C|%C|%C\n", game.getCell(2,0), game.getCell(2,1), game.getCell(2,2));
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
        System.out.printf("Error de %s%n", error);
    }

    public void showInput(String message) {
        System.out.printf("Ingrese %s:", message);
    }

    public void showTurnPlayer() {
        System.out.printf("Turno de jugador %C%n", game.playerTurn());
    }

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
