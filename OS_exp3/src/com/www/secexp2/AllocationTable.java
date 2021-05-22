package com.www.secexp2;

public class AllocationTable {
    private int number;
    private int startfreeblocknumber;
    private int blocknum;
    private char status;

    public AllocationTable(int number,int startfreeblocknumber,int blocknum,char status) {
        this.number = number;
        this.startfreeblocknumber = startfreeblocknumber;
        this.blocknum = blocknum;
        this.status = status;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getBlocknum() {
        return blocknum;
    }

    public void setBlocknum(int blocknum) {
        this.blocknum = blocknum;
    }

    public int getStartfreeblocknumber() {
        return startfreeblocknumber;
    }

    public void setStartfreeblocknumber(int startfreeblocknumber) {
        this.startfreeblocknumber = startfreeblocknumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
