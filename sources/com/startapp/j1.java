package com.startapp;

public class j1 implements Cloneable {
    public String Answer;
    public int Index;

    public j1(int i2, String str) {
        this.Index = i2;
        this.Answer = str;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
