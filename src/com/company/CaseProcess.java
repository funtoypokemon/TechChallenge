package com.company;

public class CaseProcess {
    protected String globalString, types;
    protected int x1, y1, x2, y2;
    protected int x, y;
    protected String c;

    public CaseProcess(String globalString, String types, int x1, int y1, int x2, int y2){
        this.globalString = globalString;
        this.types = types;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public CaseProcess(String globalString, String types, int x, int y, String c){
        this.globalString = globalString;
        this.types = types;
        this.x = x;
        this.y = y;
        this.c = c;
    }
}
