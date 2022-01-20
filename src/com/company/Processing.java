package com.company;

import java.util.Locale;
import java.util.Objects;

public class Processing {

    public static void workingThread() {
        // user input
        String[] canvasSymbol = UserInput.inputEntry();
        String drawCanvas = (canvasSymbol[0]).toUpperCase();
        String globalString;
        try {
            // draw canvas
            if (Objects.equals(drawCanvas, "C")) {
                globalString = DrawCanvas.drawingCanvas(Integer.parseInt(canvasSymbol[1]), Integer.parseInt(canvasSymbol[2]));
                DrawCanvas.drawingCanvas(Integer.parseInt(canvasSymbol[1]), Integer.parseInt(canvasSymbol[2]));
                System.out.println(globalString);
                caseProcess(globalString);
            }
            // recall function
            else {
                System.out.println("Please create a canvas first");
                workingThread();
            }
        } catch (Exception e) {
            System.out.println("There are some errors in your application. Please try again!");
            workingThread();
            e.printStackTrace();
        }

    }

    public static void caseProcess(String globalString) {
        //Draw shapes
        String[] shapeSymbol = UserInput.inputEntry();
        String shapeType = (shapeSymbol[0]).toUpperCase();

        // drawing case

        if (Objects.equals(shapeType, "L")) {
            globalString = DrawShapes.drawLines(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), Integer.parseInt(shapeSymbol[3]), Integer.parseInt(shapeSymbol[4]));
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(shapeType, "R")) {
            globalString = DrawShapes.drawRectangle(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), Integer.parseInt(shapeSymbol[3]), Integer.parseInt(shapeSymbol[4]));
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(shapeType, "B")) {
            globalString = DrawShapes.colorFilling(globalString, Integer.parseInt(shapeSymbol[1]), Integer.parseInt(shapeSymbol[2]), shapeSymbol[3]);
            System.out.println(globalString);
            caseProcess(globalString);
        } else if (Objects.equals(shapeType, "Q")) {
            System.exit(0);
        } else {
            System.out.println("Please re-enter your command!");
            caseProcess(globalString);
        }
    }
}
