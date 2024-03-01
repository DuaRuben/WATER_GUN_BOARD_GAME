package src.Model;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    //Manages all the opponents including forts creation
    private ArrayList<Fort> fortList;
    private ArrayList<Cell> cellUsedInForts;

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
        for(int i=0;i<cellUsedInForts.size();i++){
            if(cellUsedInForts.get(i).getPosition().equals(position)){
                return cellUsedInForts.get(i).getFortName();
            }
        }
        return ' ';
    }

    //randomFortGenerator
    public ArrayList<Cell> randomFortGenerator(int n){
        // create a connected cellarray
        ArrayList<Cell> cellArrayForFort = new ArrayList<>();
        Random random = new Random();
        while(cellArrayForFort.size() < 5){
            int row;
            char col;
            String position;
            do {
                row = random.nextInt(10);
                col = (char) ('A' + random.nextInt(10));
                position = col + Integer.toString(row);
            }while(isCellUsedInFort(position)!=' ');
            //check Left,right,bottom,top
        }
        return cellArrayForFort;

    }
    //FortList creation
    public void fortListCreation(int number){
        char fortName ='A';
        for(int i=0;i<number;i++){
            ArrayList<Cell> cellArray = randomFortGenerator(number);
            Fort newFort = new Fort(fortName,cellArray,false,5,0,0);
            this.addFort(newFort);
            fortName++;
        }
    }

    public void calculatePointsForFortList(){
        int[] points ={0,1,2,5,20,20};
        for(int i=0;i<fortList.size();i++){
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
            System.out.println("Opponent #"+i+" of "+fortList.size()+" shot you for "+fortList.get(i).getLastPointScored()+" points!");
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
