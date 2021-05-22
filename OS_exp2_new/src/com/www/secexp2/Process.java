package com.www.secexp2;

import java.util.ArrayList;

public class Process {
    public int num;
    public int size;
    public String name;
    public ArrayList<Integer> blocktable = new ArrayList<>();

    public ArrayList<Integer> getBlocktable() {
        return blocktable;
    }

    public void setBlocktable(ArrayList<Integer> blocktable) {
        this.blocktable = blocktable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
