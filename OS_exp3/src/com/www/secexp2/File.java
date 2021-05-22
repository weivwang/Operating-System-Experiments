package com.www.secexp2;

public class File {
    public int num;
    public String filename;
    public int filesize;
    public int tablenum;
    private int startblock;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getPhysicalrecord() {
        return physicalrecord;
    }

    public void setPhysicalrecord(int physicalrecord) {
        this.physicalrecord = physicalrecord;
    }

    private int physicalrecord;
    private int track;
    private int cylinder;

    public int getStartblock() {
        return startblock;
    }

    public void setStartblock(int startblock) {
        this.startblock = startblock;
    }

    public int getTablenum() {
        return tablenum;
    }

    public void setTablenum(int tablenum) {
        this.tablenum = tablenum;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
