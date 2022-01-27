package com.company;

import java.util.Scanner;

public class UserInput {
    public static String[] inputEntry(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your command: ");
        String userInput = input.nextLine();
        String[] symbol = userInput.split(" ");
        return symbol;
    }
}
