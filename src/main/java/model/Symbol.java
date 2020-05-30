package model;

public enum Symbol {
    Empty, O, X;

    public char toChar(){
        char result;
        switch (this) {
            case O:
                result = 'O';
                break;
            case X:
                result = 'X';
                break;
            default:
                result = ' ';
        }
        return result;
    }
}
