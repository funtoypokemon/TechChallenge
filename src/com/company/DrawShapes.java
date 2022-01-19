package com.company;

import java.util.Objects;

public class DrawShapes {

    public static String drawLines(String globalString, int x1, int y1, int x2, int y2) {
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
        return globalString;
    }

    public static String drawRectangle(String globalString, int x1, int y1, int x2, int y2) {
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
        return globalString;
    }

    public static String colorFilling(String globalString, int x, int y, String c) {
        // len of a line * line_num + index on line + 1(begin at 1)
        int pos = (globalString.indexOf("\n") + 1) * y + x;
//        System.out.println("Pos: " + pos);
//        System.out.println("Index of n: " + globalString.indexOf("\n"));
        int pos1 = (globalString.indexOf("\n") + 1) * y + x - 1;
//        System.out.println("Pos1: " + pos1);
        if ((globalString.charAt(pos1) != '-') && (globalString.charAt(pos1) != '|') && (globalString.charAt(pos1) == globalString.charAt(pos))) {
            colorFilling(globalString, x - 1, y, c);
        }
        int pos2 = (globalString.indexOf("\n") + 1) * y + x + 1;
//        System.out.println("Pos2: " + pos2);
        if ((globalString.charAt(pos2) != '-') && (globalString.charAt(pos2) != '|') && (globalString.charAt(pos2) == globalString.charAt(pos))) {
            colorFilling(globalString, x + 1, y, c);
        }
        int pos3 = (globalString.indexOf("\n") + 1) * (y - 1) + x;
//        System.out.println("Pos3: " + pos3);
        if ((globalString.charAt(pos3) != '-') && (globalString.charAt(pos3) != '|') && (globalString.charAt(pos3) == globalString.charAt(pos))) {
            colorFilling(globalString, x, y - 1, c);
        }
        int pos4 = (globalString.indexOf("\n") + 1) * (y + 1) + x;
        System.out.println("Pos: " + pos + ", Pos1: " + pos1 + ", Pos2: " + pos2 + ", Pos3: " + pos3 + ", Pos4: " + pos4);
        if ((globalString.charAt(pos4) != '-') && (globalString.charAt(pos4) != '|') && (globalString.charAt(pos4) == globalString.charAt(pos))) {
            colorFilling(globalString, x, y + 1, c);
        }
        globalString = globalString.substring(0, pos) + c + globalString.substring(pos + 1);
        return globalString;
    }
}
