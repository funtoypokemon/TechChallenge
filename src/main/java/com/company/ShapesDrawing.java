package com.company;

public class ShapesDrawing {

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
                    for (int yPos = y1; yPos <= y2; yPos++) {
                        for (int xPos = x1; xPos <= x2; xPos++) {
                            StringBuilder tempLineString = new StringBuilder(lineString[yPos]);
                            tempLineString.replace(xPos, xPos + 1, "x");
                            lineString[yPos] = String.valueOf(tempLineString);
                        }
                    }
                }

                //line on x axis
                if (y1 == y2) {
                    StringBuilder tempLineString = new StringBuilder(lineString[y1]);
                    for (int xPos = x1; xPos <= x2; xPos++) {
                        tempLineString.replace(xPos, xPos + 1, "x");
                    }
                    lineString[y1] = String.valueOf(tempLineString);
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
                for (int yPos = y1; yPos <= y2; yPos++) {
                    for (int xPos = x1; xPos <= x2; xPos++) {
                        StringBuilder tempRectString = new StringBuilder(rectString[yPos]);
                        tempRectString.replace(xPos, xPos + 1, "x");
                        if (xPos > x1 && xPos < x2 && yPos > y1 && yPos < y2) {
                            tempRectString.replace(xPos, xPos + 1, " ");
                        }
                        rectString[yPos] = String.valueOf(tempRectString);
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

    public static String fillColor(String globalString, int x, int y, String color) {

        try{
            // len of a line * line_num + index on line + 1(begin at 1)
            int currentPos = (globalString.indexOf("\n") + 1) * y + x;
            // save char at current position to avoid the changes when apply recursion
            char tempChar = globalString.charAt(currentPos);

            // if the char at current currentPos is different from c color
            if ((globalString.charAt(currentPos) != color.charAt(0))) {
                globalString = globalString.substring(0, currentPos) + color + globalString.substring(currentPos + 1);
                //        System.out.println("Pos: " + currentPos);
//        System.out.println("Index of n: " + globalString.indexOf("\n"));
                // the left node of current position
                int leftPos = (globalString.indexOf("\n") + 1) * y + x - 1;
//        System.out.println("Pos1: " + leftPos);
                if ((globalString.charAt(leftPos) != '-') && (globalString.charAt(leftPos) != '|') && (globalString.charAt(leftPos) == tempChar)) {
                    globalString = fillColor(globalString, x - 1, y, color);
                }
                // the right node of current position
                int rightPos = (globalString.indexOf("\n") + 1) * y + x + 1;
//        System.out.println("Pos2: " + rightPos);
                if ((globalString.charAt(rightPos) != '-') && (globalString.charAt(rightPos) != '|') && (globalString.charAt(rightPos) == tempChar)) {
                    globalString = fillColor(globalString, x + 1, y, color);
                }
                // the above node of current position
                int abovePos = (globalString.indexOf("\n") + 1) * (y - 1) + x;
//        System.out.println("Pos3: " + abovePos);
                if ((globalString.charAt(abovePos) != '-') && (globalString.charAt(abovePos) != '|') && (globalString.charAt(abovePos) == tempChar)) {
                    globalString = fillColor(globalString, x, y - 1, color);
                }
                // the below node of current position
                int belowPos = (globalString.indexOf("\n") + 1) * (y + 1) + x;
//        System.out.println("Pos: " + currentPos + ", Pos1: " + leftPos + ", Pos2: " + rightPos + ", Pos3: " + abovePos + ", Pos4: " + belowPos);
                if ((globalString.charAt(belowPos) != '-') && (globalString.charAt(belowPos) != '|') && (globalString.charAt(belowPos) == tempChar)) {
                    globalString = fillColor(globalString, x, y + 1, color);
                }
            }
        }catch (StackOverflowError e){
            System.out.println("Your coordinates is not right");
            fillColor(globalString, x, y, color);
        }
        return globalString;
    }
}
