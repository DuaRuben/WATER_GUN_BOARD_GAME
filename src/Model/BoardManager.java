package src.Model;

import java.util.ArrayList;

public class BoardManager {
    //Manages the array of board
    private ArrayList<ArrayList<Cell>> board = new ArrayList<>();

    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }


    //board creation
    public void boardCreation(GameManager gameManager){
        char row ='A';
        for(int i=0;i<10;i++,row++){
            ArrayList<Cell> cellRow = new ArrayList<>();
            int col = 1;
            for(int j=0;j<10;j++,col++){
                String position = row+ Integer.toString(col);
                Cell newCell = new Cell(position,'~',' ');
                char fortName = gameManager.isCellUsedInFort(position);
                newCell.setFortName(fortName);
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
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-3d", col++);
        }
        System.out.println();

        // Print row headers and board values
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-2c", row++);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-3s", board.get(i).get(j).getValue());
            }
            System.out.println();
        }
    }
    //prints the final board
    public void printFinalBoard(){
        System.out.println("Game Board:");
        int col = 1;
        char row = 'A';
        System.out.print("  ");
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if( i == 0){
                    System.out.print(col+"  ");
                    col++;
                }
                else if( j == 0){
                    System.out.print(row+"  ");
                    row++;
                }
                else if(board.get(i-1).get(j-1).getValue() == 'X'){
                    System.out.print(Character.toLowerCase(board.get(i-1).get(j-1).getFortName())+"  ");
                }
                else if(board.get(i-1).get(j-1).getFortName() ==' '){
                    if(board.get(i-1).get(j-1).getValue() =='~'){
                        System.out.print("."+"  ");
                    }
                    else{
                        System.out.print(" "+"  ");
                    }
                }
                else{
                    System.out.print(board.get(i-1).get(j-1).getFortName()+"  ");
                }
            }
            System.out.println();
        }
    }
    //print Cheat Board
    public void printCheatBoard(){
        System.out.println("Game Board:");
        int col = 1;
        char row = 'A';
        System.out.print("  ");
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if( i == 0){
                    System.out.print(col+"  ");
                    col++;
                }
                else if( j == 0){
                    System.out.print(row+"  ");
                    row++;
                }
                else if(board.get(i-1).get(j-1).getFortName() ==' '){
                    System.out.print("."+"  ");
                }
                else{
                    System.out.print(board.get(i-1).get(j-1).getFortName()+"  ");
                }
            }
            System.out.println();
        }
    }
    //returns hit or miss on userInput
    public boolean isHit(String userInput,GameManager gameManager){
        //return true for hit and false for miss
        boolean ans = false;
        int size = userInput.length();
        int col;
        if(size == 2){
            col = Character.getNumericValue(userInput.charAt(1))-1;
        }
        else{
            col = 9;
        }
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
