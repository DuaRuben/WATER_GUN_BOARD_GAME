package src.Model;

import java.util.ArrayList;

public class BoardManager {
    //Manages the array of board
    private ArrayList<ArrayList<Cell>> board = new ArrayList<>();

    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }


    //board creation
    public void boardCreation(){
        GameManager gameManager = new GameManager();
        char row ='A';
        for(int i=0;i<10;i++,row++){
            ArrayList<Cell> cellRow = new ArrayList<>();
            int col = 1;
            for(int j=0;j<10;j++,col++){
                String position = row+ Integer.toString(col);
                Cell newCell = new Cell(position,'~',' ');
                newCell.setFortName(gameManager.isCellUsedinFort(position));
                cellRow.add(newCell);
            }
            board.add(cellRow);
        }
    }

    //prints the board
    public void printBoard(){
        System.out.println("Game Board:");
        int col = 1;
        char row = 'A';
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if( i == 0){
                    System.out.println(col);
                    col++;
                }
                else if( j == 0){
                    System.out.println(row);
                    row++;
                }
                else{
                    System.out.println(board.get(i-1).get(j-1).getValue());
                }
            }
        }
    }
    //prints the cheat board
    public void printCheatBoard(){
        System.out.println("Game Board:");
        int col = 1;
        char row = 'A';
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if( i == 0){
                    System.out.println(col);
                    col++;
                }
                else if( j == 0){
                    System.out.println(row);
                    row++;
                }
                else if(board.get(i-1).get(j-1).getFortName() ==' '){
                    System.out.println(".");
                }
                else{
                    System.out.println(board.get(i-1).get(j-1).getFortName());
                }
            }
        }
    }
    //returns hit or miss on userInput
}
