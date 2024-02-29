package src.UI;

import java.util.Scanner;

public class TextUI {
    public void start(){
        boolean isDone = false;
        while(!isDone) {
            System.out.println("");
            System.out.println("Game Board:");
            //print game board if no cheat
            // else print the cheat game board
            System.out.println("Opponents points: 0 / 2500.");
            System.out.println("Enter Your Move:");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            //Give the result as hit or miss
            //Show Opponents point;
            //Check winning or losing condition to exit the loop
        }

    }

}
