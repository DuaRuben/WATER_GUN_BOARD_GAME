package src.UI;

import src.Model.BoardManager;
import src.Model.GameManager;

import java.util.Scanner;

public class TextUI {
    public int start(int forts, boolean isCheat){
        boolean isDone = false;
        BoardManager boardManager = new BoardManager();
        GameManager gameManager = new GameManager();
        //print cheat board if condition is true
        boolean isGameCreated = gameManager.fortListCreation(forts);
        if(!isGameCreated){
            return 1;
        }
        boardManager.boardCreation(gameManager);
        if(isCheat){
            boardManager.printCheatBoard();
        }
        System.out.println("Starting game with" +forts+ "forts.");
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
            boolean result = boardManager.isHit(userInput,gameManager);
            if(result){
                System.out.println("HIT!");
            }
            else{
                System.out.println("Miss.");
            }
            //Show Opponents point;
            gameManager.showOpponentsPoints();
            //Check winning or losing condition to exit the loop
            if(gameManager.hasPlayerLost()){
                isDone = true;
                System.out.println("I'm sorry, your fort is all wet! They win!");
            }
            if(gameManager.hasPlayerWon()){
                isDone = true;
                System.out.println("Congratulations! You won!");
            }
        }
        boardManager.printFinalBoard();
        System.out.println("Opponents points:"+ gameManager.getTotalPoints() +"/ 2500.");
        System.out.println("(Lower case fort letters are where you shot.)");
        return 0;

    }

}
