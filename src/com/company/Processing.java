package com.company;

import java.util.Objects;

public class Processing {

    public static void workingThread() {
        // user input
        String[] symbol = UserInput.inputEntry();
        String drawCanvas = symbol[0];
        // draw canvas
        if (Objects.equals(drawCanvas, "C")) {
            String globalString = DrawCanvas.drawingCanvas(Integer.parseInt(symbol[1]), Integer.parseInt(symbol[2]));
            DrawCanvas.drawingCanvas(Integer.parseInt(symbol[1]), Integer.parseInt(symbol[2]));
            System.out.println(globalString);
            caseProcess(globalString);
        }
        // recall function
        else {
            System.out.println("Please create a canvas first");
            workingThread();
        }
    }

    public static void caseProcess(String globalString){
        //Draw shapes
        String[] shapeSymbol = UserInput.inputEntry();
        String drawShape = shapeSymbol[0];

        // drawing case
        if (Objects.equals(drawShape, "L")) {
            globalString = DrawShapes.drawLines(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), Integer.parseInt(shapeSymbol[3]), Integer.parseInt(shapeSymbol[4]));
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(drawShape, "R")) {
            globalString = DrawShapes.drawRectangle(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), Integer.parseInt(shapeSymbol[3]), Integer.parseInt(shapeSymbol[4]));
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(drawShape, "B")) {
            globalString = DrawShapes.colorFilling(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), shapeSymbol[3]);
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(drawShape, "Q")) {
            System.exit(0);
        } else {
            System.out.println("Please re-enter your command!");
            caseProcess(globalString);
        }
    }
}
