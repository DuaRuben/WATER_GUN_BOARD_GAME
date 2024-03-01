package src.Model;

import java.util.ArrayList;

public class Fort {
    private String fortName;
    private ArrayList<Cell> cellArray;
    private boolean isDestroyed;
    private int undamagedCells;
    private int points;

    public Fort(String fortName, ArrayList<Cell> cellArray, boolean isDestroyed, int undamagedCells, int points) {
        this.fortName = fortName;
        this.cellArray = cellArray;
        this.isDestroyed = isDestroyed;
        this.undamagedCells = undamagedCells;
        this.points = points;
    }

    public String getFortName() {
        return fortName;
    }

    public ArrayList<Cell> getCellArray() {
        return cellArray;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getUndamagedCells() {
        return undamagedCells;
    }

    public int getPoints() {
        return points;
    }

    public void setFortName(String fortName) {
        this.fortName = fortName;
    }

    public void setCellArray(ArrayList<Cell> cellArray) {
        this.cellArray = cellArray;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public void setUndamagedCells(int undamagedCells) {
        this.undamagedCells = undamagedCells;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
