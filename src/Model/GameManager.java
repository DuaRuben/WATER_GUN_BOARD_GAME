package src.Model;

import java.util.ArrayList;

public class GameManager {
    //Manages all the opponents including forts creation
    private ArrayList<Fort> fortList;

    public ArrayList<Fort> getFortList() {
        return fortList;
    }

    public void setFortList(ArrayList<Fort> fortList) {
        this.fortList = fortList;
    }

    public void addFort(Fort newFort){
        this.fortList.add(newFort);
    }
    //FortList creation
    public void fortListCreation(int number){
        char fortName ='A';
        for(int i=0;i<number;i++){
            ArrayList<Cell> cellArray = new ArrayList<>();
            Fort newFort = new Fort(fortName,cellArray,false,5,0);
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
