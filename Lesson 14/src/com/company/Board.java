package com.company;

public class Board {
    private static int boardSize =3;
    private static final char x= 'x';
    private static final char o= 'o';
    private static final char empty= '.';
    private char[][] board;

    public Board () {
        for (int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
                this.board [i][j] = empty;
            }
        }

        }

    public void placeSimbol (int row, int col, char sym) throws PositionExeption, AlredyUsedExeption {
        if(row<0||col<0||row>=boardSize||col>=boardSize){
            throw new PositionExeption();
        }
        if (this.board[row][col]!= empty) {
            throw new AlredyUsedExeption();
        }
        this.board[row][col]= sym;
    }
    public void draw () {
        for (int i=0;i<boardSize;i++){
            for (int j=0;j<boardSize;j++){
               // " " +cell+ " "
                System.out.print(" "+ this.board [i][j]+" ");
            }
            System.out.println();
        }
    }
    //'-' - игра продолжается

    //'x'/'o' - выиграл кто либо

    //'*' - ничья

    public  char checkWin() {

        // проверяем по горизонтали

        for (int i=0;i<boardSize;i++) {
            boolean isWin = true;
            for (int j = 0; j < boardSize - 1; j++) {
                if (this.board [i] [j]== empty ||
                        this.board[i][j] != this.board[i][j + 1]) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return this.board[i][0];
            }
        }

        // проверяем по вертикали

        for (int i=0;i<boardSize ;i++) {
            boolean isWin = true;
            for (int j = 0; j < boardSize - 1 ; j++) {
                if (this.board [j] [i]== empty ||
                        this.board[j][i] != this.board[j+1][i]) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                return this.board[0][i];
            }
        }
        //todo проверки диагоналей
    }

}
