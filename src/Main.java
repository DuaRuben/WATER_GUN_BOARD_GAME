package src;

import src.UI.TextUI;

import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int forts = 5;
        boolean cheat = false;
        if(args.length != 0) {
            if(args.length > 2) {
                System.err.println("Invalid Input");
                System.exit(1);
            } else {
                try {
                    forts = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    System.err.println("Number of forts must be an integer");
                    System.exit(1);
                }
            }
            if(args.length == 2 && Objects.equals(args[1], "--cheat")) {
                cheat = true;
            }
        }
        TextUI UI = new TextUI();
        UI.start(forts, cheat);
    }
}