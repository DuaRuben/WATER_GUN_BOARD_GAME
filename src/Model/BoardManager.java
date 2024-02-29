package src.Model;

import java.util.ArrayList;

public class BoardManager {
    //Manages the array of board
    private ArrayList<ArrayList<Cell>> board = new ArrayList<>();

    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }

    //board creation

    //prints the board
    public void printBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.println(board.get(i).get(j).getValue());
            }
        }
    }
    //prints the cheat board
    //returns hit or miss on userInput
}
