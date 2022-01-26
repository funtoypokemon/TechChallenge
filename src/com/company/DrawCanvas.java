package com.company;

import java.util.Scanner;


public class DrawCanvas {

    public static String drawingCanvas(int w, int h) {
        String globalString = "";
        int maxWeight = w + 2;
        int maxHeight = h + 2;
        for (int yPos = 0; yPos < maxHeight; yPos++) {
            for (int xPos = 0; xPos < maxWeight; xPos++) {
                if (yPos == 0 || yPos == maxHeight - 1) {
                    globalString += "-";
                }else if(xPos == 0 || xPos == maxWeight - 1){
                    globalString += "|";
                }else{
                    globalString += " ";
                }
            }
            globalString += "\n";
        }
        return globalString;
    }
}
