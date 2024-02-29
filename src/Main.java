package src;

import src.UI.TextUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------------");
        System.out.println("Welcome to Fort Defense!");
        System.out.println("by Ruben and Pratham");
        System.out.println("------------------------");
        TextUI UI = new TextUI();
        UI.start();
    }
}