package src.Model;

import java.util.ArrayList;

public class GameManager {
    //Manages all the opponents including forts creation
    private ArrayList<Fort> fortList;
    private ArrayList<Cell> cellUsedinForts;

    public ArrayList<Fort> getFortList() {
        return fortList;
    }

    public ArrayList<Cell> getCellUsedinForts() {
        return cellUsedinForts;
    }

    public void setFortList(ArrayList<Fort> fortList) {
        this.fortList = fortList;
    }

    public void addFort(Fort newFort){
        this.fortList.add(newFort);
    }

    public char isCellUsedinFort(String position){
        for(int i=0;i<cellUsedinForts.size();i++){
            if(cellUsedinForts.get(i).getPosition().equals(position)){
                return cellUsedinForts.get(i).getFortName();
            }
        }
        return ' ';
    }

    //randomFortGenerator
    public ArrayList<Cell> randomFortGenerator(){
        // create a connected cellarray
        // put the cells used in cellUsedinForts array with fortname
        ArrayList<Cell> cellArrayForFort = new ArrayList<>();
        return cellArrayForFort;

    }
    //FortList creation
    public void fortListCreation(int number){
        char fortName ='A';
        for(int i=0;i<number;i++){
            ArrayList<Cell> cellArray = randomFortGenerator();
            Fort newFort = new Fort(fortName,cellArray,false,5,0,0);
            this.addFort(newFort);
            fortName++;
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
