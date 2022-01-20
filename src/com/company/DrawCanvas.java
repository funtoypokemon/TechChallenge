package com.company;

import java.util.Scanner;


public class DrawCanvas {

    public static String drawingCanvas(int w, int h) {
        String globalString = "";
        int maxWeight = w + 2;
        int maxHeight = h + 2;
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWeight; j++) {
                if (i == 0 || i == maxHeight - 1) {
                    globalString += "-";
                }else if(j == 0 || j == maxWeight - 1){
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
