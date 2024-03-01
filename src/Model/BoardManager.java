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
    public boolean isHit(String userInput){
        //return true for hit and false for miss
        GameManager gameManager = new GameManager();
        boolean ans = false;
        int col = (int)(userInput.charAt(1))-1;
        int row = (int)userInput.charAt(0)-65;
        char value = board.get(row).get(col).getValue();
        gameManager.calculatePointsForFortList();
        if(value == '~'){
            char fortName = board.get(row).get(col).getFortName();
            if(fortName ==' '){
                board.get(row).get(col).setValue(' ');
                ans = false;
            }
            else{
                board.get(row).get(col).setValue('X');
                ans = true;
                ArrayList<Fort> fortList = gameManager.getFortList();
                for(int i=0;i<fortList.size();i++){
                    if(fortList.get(i).getFortName() == board.get(row).get(col).getFortName()){
                        fortList.get(i).setUndamagedCells(fortList.get(i).getUndamagedCells()-1);
                        break;
                    }
                }
                gameManager.setFortList(fortList);
            }
        }
        else if(value == 'X'){
            ans = true;
        }
        else if(value == ' '){
            ans = false;
        }
        return ans;
    }
}
