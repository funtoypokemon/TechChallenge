package com.company;

import java.util.Objects;

public class DrawShapes {

    public static String drawLines(String globalString, int x1, int y1, int x2, int y2) {

        try {
            String[] lineString = globalString.split("\n");
            // check if its a line or not
            if ((x1 == x2 || y1 == y2) && !(x1 == x2 && y1 == y2)) {
                //swap 2 var
                if (x1 > x2) {
                    x1 = x1 + x2;
                    x2 = x1 - x2;
                    x1 = x1 - x2;
                }
                if (y1 > y2) {
                    y1 = y1 + y2;
                    y2 = y1 - y2;
                    y1 = y1 - y2;
                }
                // line on y axis
                if (x1 == x2) {
                    for (int i = y1; i <= y2; i++) {
                        for (int j = x1; j <= x2; j++) {
                            StringBuffer tempString = new StringBuffer(lineString[i]);
                            tempString.replace(j, j + 1, "x");
                            lineString[i] = String.valueOf(tempString);
                        }

                    }

                }

                //line on x axis
                if (y1 == y2) {
                    StringBuffer tempString = new StringBuffer(lineString[y1]);
                    for (int j = x1; j <= x2; j++) {
                        tempString.replace(j, j + 1, "x");
                    }
                    lineString[y1] = String.valueOf(tempString);
                }
            }
            // recall the function
            else {
                System.out.println("This is not a line");
                drawLines(globalString, x1, y1, x2, y2);
            }
            // assign to globalString
            globalString = String.join("\n", lineString);
        } catch (StackOverflowError e) {
            System.out.println("Your line is out of range. Please choose a right line coordinates try again!");
            drawLines(globalString, x1, y1, x2, y1);
        }
        return globalString;

    }

    public static String drawRectangle(String globalString, int x1, int y1, int x2, int y2) {
        try{
            String[] rectString = globalString.split("\n");
            // check if its a line or not
            if (x1 != x2 || y1 != y2) {
                //swap 2 var
                if (x1 > x2) {
                    x1 = x1 + x2;
                    x2 = x1 - x2;
                    x1 = x1 - x2;
                }
                if (y1 > y2) {
                    y1 = y1 + y2;
                    y2 = y1 - y2;
                    y1 = y1 - y2;
                }
                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        StringBuffer tempString = new StringBuffer(rectString[i]);
                        tempString.replace(j, j + 1, "x");
                        if (j > x1 && j < x2 && i > y1 && i < y2) {
                            tempString.replace(j, j + 1, " ");
                        }
                        rectString[i] = String.valueOf(tempString);
                    }
                }
            } else {
                System.out.println("This is not a rectangle");
                drawRectangle(globalString, x1, y1, x2, y2);
            }
            globalString = String.join("\n", rectString);
        } catch(StackOverflowError e){
            System.out.println("Your rectangle is out of range. Please choose a right rectangle coordinates try again!");
            drawRectangle(globalString, x1, y1, x2, y1);
        }

        return globalString;
    }

    public static String colorFilling(String globalString, int x, int y, String c) {

        try{
            // len of a line * line_num + index on line + 1(begin at 1)
            int pos = (globalString.indexOf("\n") + 1) * y + x;
            // save char at current position to avoid the changes when apply recursion
            char tempChar = globalString.charAt(pos);

            // if the char at current pos is different from c color
            if ((globalString.charAt(pos) != c.charAt(0))) {
                globalString = globalString.substring(0, pos) + c + globalString.substring(pos + 1);
                //        System.out.println("Pos: " + pos);
//        System.out.println("Index of n: " + globalString.indexOf("\n"));
                // the left node of current position
                int pos1 = (globalString.indexOf("\n") + 1) * y + x - 1;
//        System.out.println("Pos1: " + pos1);
                if ((globalString.charAt(pos1) != '-') && (globalString.charAt(pos1) != '|') && (globalString.charAt(pos1) == tempChar)) {
                    globalString = colorFilling(globalString, x - 1, y, c);
                }
                // the right node of current position
                int pos2 = (globalString.indexOf("\n") + 1) * y + x + 1;
//        System.out.println("Pos2: " + pos2);
                if ((globalString.charAt(pos2) != '-') && (globalString.charAt(pos2) != '|') && (globalString.charAt(pos2) == tempChar)) {
                    globalString = colorFilling(globalString, x + 1, y, c);
                }
                // the above node of current position
                int pos3 = (globalString.indexOf("\n") + 1) * (y - 1) + x;
//        System.out.println("Pos3: " + pos3);
                if ((globalString.charAt(pos3) != '-') && (globalString.charAt(pos3) != '|') && (globalString.charAt(pos3) == tempChar)) {
                    globalString = colorFilling(globalString, x, y - 1, c);
                }
                // the below node of current position
                int pos4 = (globalString.indexOf("\n") + 1) * (y + 1) + x;
//        System.out.println("Pos: " + pos + ", Pos1: " + pos1 + ", Pos2: " + pos2 + ", Pos3: " + pos3 + ", Pos4: " + pos4);
                if ((globalString.charAt(pos4) != '-') && (globalString.charAt(pos4) != '|') && (globalString.charAt(pos4) == tempChar)) {
                    globalString = colorFilling(globalString, x, y + 1, c);
                }
            }
        }catch (StackOverflowError e){
            System.out.println("Your coordinates is not right");
            colorFilling(globalString, x, y, c);
        }
        return globalString;
    }
}
