package com.company;

import java.util.Scanner;

public class UserInput {
    public static String[] inputEntry(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your command: ");
        String input = keyboard.nextLine();
        String[] symbol = input.split(" ");
        return symbol;
    }
}
