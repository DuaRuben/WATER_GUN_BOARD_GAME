package src.UI;

import src.Model.BoardManager;
import src.Model.GameManager;

import java.util.Scanner;

public class TextUI {
    public void start(){
        boolean isDone = false;
        int n = 5;
        boolean isCheat = true;
        BoardManager boardManager = new BoardManager();
        GameManager gameManager = new GameManager();
        //print cheat board if condition is true
        if(isCheat){
            boardManager.printCheatBoard();
        }
        System.out.println("Starting game with" +n+ "forts.");
        System.out.println("------------------------");
        System.out.println("Welcome to Fort Defense!");
        System.out.println("by Ruben and Pratham");
        System.out.println("------------------------");
        while(!isDone) {
            boardManager.printBoard();
            System.out.println("Opponents points:"+ gameManager.getTotalPoints() +"/ 2500.");
            System.out.println("Enter Your Move:");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            //Give the result as hit or miss
            //Show Opponents point;
            //Check winning or losing condition to exit the loop
        }

    }

}
