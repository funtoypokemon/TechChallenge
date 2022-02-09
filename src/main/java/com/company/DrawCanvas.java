package com.company;

public class DrawCanvas {

    public static String drawingCanvas(int w, int h) {
        StringBuilder globalString = new StringBuilder();
        int maxWeight = w + 2;
        int maxHeight = h + 2;
        for (int yPos = 0; yPos < maxHeight; yPos++) {
            for (int xPos = 0; xPos < maxWeight; xPos++) {
                if (yPos == 0 || yPos == maxHeight - 1) {
                    globalString.append("-");
                }else if(xPos == 0 || xPos == maxWeight - 1){
                    globalString.append("|");
                }else{
                    globalString.append(" ");
                }
            }
            globalString.append("\n");
        }
        return globalString.toString();
    }
}
