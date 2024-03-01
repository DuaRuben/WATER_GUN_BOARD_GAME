package src.Model;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    //Manages all the opponents including forts creation
    private ArrayList<Fort> fortList = new ArrayList<>();
    private ArrayList<Cell> cellUsedInForts = new ArrayList<>();

    private int i =0;
    private int j =0;

    public ArrayList<Fort> getFortList() {
        return fortList;
    }

    public ArrayList<Cell> getCellUsedInForts() {
        return cellUsedInForts;
    }

    public void setFortList(ArrayList<Fort> fortList) {
        this.fortList = fortList;
    }

    public void addFort(Fort newFort){
        this.fortList.add(newFort);
    }

    //to check if a cell is already in Fort
    public char isCellUsedInFort(String position){
        if(cellUsedInForts.isEmpty()){
            return ' ';
        }
        for(int i=0;i<cellUsedInForts.size();i++){
            if(cellUsedInForts.get(i).getPosition().equals(position)){
                return cellUsedInForts.get(i).getFortName();
            }
        }
        return ' ';
    }

    public boolean isValidIndex(int i,int j){
        return (i < 10 && i >= 0) && (j < 10 && j >= 0);
    }
    public boolean exploreCells(int index, ArrayList<Cell> cellArray,Cell startCell,char fortName){
        int row = (startCell.getPosition().charAt(0)-'A');
        int col = Character.getNumericValue(startCell.getPosition().charAt(1))-1;
        String position;
        //check Left
        int leftrow = row;
        int leftcol = col -1;
        if(isValidIndex(leftrow,leftcol)){
            position  =  (char)(leftrow+'A') + Integer.toString(leftcol+1);
            if(isCellUsedInFort(position)==' '){
                Cell newcell = new Cell(position,'~',fortName);
                cellArray.add(newcell);
            }
        }
        if(cellArray.size() == 5){
            return true;
        }
        //check right
        int rightrow = row;
        int rightcol = col+1;
        if(isValidIndex(rightrow,rightcol)){
            position  =  (char)(rightrow+'A') + Integer.toString(rightcol+1);
            if(isCellUsedInFort(position)==' '){
                Cell newcell = new Cell(position,'~',fortName);
                cellArray.add(newcell);
            }
        }
        if(cellArray.size() == 5){
            return true;
        }
        //check up
        int uprow = row-1;
        int upcol = col;
        if(isValidIndex(uprow,upcol)){
            position  =  (char)(uprow+'A') + Integer.toString(upcol+1);
            if(isCellUsedInFort(position)==' '){
                Cell newcell = new Cell(position,'~',fortName);
                cellArray.add(newcell);
            }
        }
        if(cellArray.size() == 5){
            return true;
        }
        //check down
        int downrow = row+1;
        int downcol = col;
        if(isValidIndex(downrow,downcol)){
            position  =  (char)(downrow+'A') + Integer.toString(downcol+1);
            if(isCellUsedInFort(position)==' '){
                Cell newcell = new Cell(position,'~',fortName);
                cellArray.add(newcell);
            }
        }
        //check if cellArray is full return true
        if(cellArray.size() == 5){
            return true;
        }
        else{
            index++;//else increment index
        }
        //if index is invalid return false;
        if(index >= cellArray.size()){
            return false;
        }
        else{
            exploreCells(index,cellArray,cellArray.get(index),fortName);//else call exploreCells with startCell = cellArray[index]
        }
        return true; // will never reach hear
    }

    //randomFortGenerator
    public boolean randomFortGenerator(char fortName,ArrayList<Cell> cellArray){
        // create a connected cellArrayForFort
        boolean flag = false;
        int index = 0;
        Random random = new Random();
        int col;
        char row;
        String position;
        Cell startCell;
        do {
            col = random.nextInt(9);
            row = (char) ('A' + random.nextInt(10));
            position = row + Integer.toString(col+1);
            startCell = new Cell(position, '~', ' ');
        } while (isCellUsedInFort(position) != ' ');
        startCell.setFortName(fortName);
        cellArray.add(startCell);
        flag = exploreCells(index, cellArray, startCell, fortName);
        if(flag == false){
            return flag;
        }
        for(int i=0;i<cellArray.size();i++){
            cellUsedInForts.add(cellArray.get(i));
        }
        return flag;
    }
    //FortList creation
    public boolean fortListCreation(int number){
        char fortName ='A';
        for(int i=0;i<number;i++){
            ArrayList<Cell> cellArray = new ArrayList<>();
            boolean flag = false;
            boolean isCreated = randomFortGenerator(fortName,cellArray);
            if(isCreated == false){
                return isCreated;
            }
            Fort newFort = new Fort(fortName,cellArray,false,5,0,20);
            this.addFort(newFort);
            fortName++;
        }
        return true;
    }

    public void calculatePointsForFortList(){
        int[] points ={0,1,2,5,20,20};
        for(int i=0;i<fortList.size();i++){
            System.out.println(fortList.get(i).getUndamagedCells());
            fortList.get(i).setLastPointScored(points[fortList.get(i).getUndamagedCells()]);
            fortList.get(i).setPoints(fortList.get(i).getPoints()+points[fortList.get(i).getUndamagedCells()]);
        }
    }


    //Calculates their total points
    public int getTotalPoints(){
        int sum = 0;
        for(int i=0;i< fortList.size();i++){
            sum+=fortList.get(i).getPoints();
        }
        return sum;
    }
    //Show Oppoenets Points
    public void showOpponentsPoints(){
        for(int i=0;i<fortList.size();i++){
            System.out.println("Opponent #"+(i+1)+" of "+fortList.size()+" shot you for "+fortList.get(i).getLastPointScored()+" points!");
        }
    }

    //Checks winning and losing condition
    public boolean hasPlayerWon(){
        for(int i=0;i< fortList.size();i++){
            if(fortList.get(i).getUndamagedCells()!=0){
                return false;
            }
        }
        return true;
    }

    public boolean hasPlayerLost(){
        if(this.getTotalPoints()>2500){
            return true;
        }
        else{
            return false;
        }
    }
}
