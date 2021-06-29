package com.www.secexp2;

public class Mutex {
    private boolean mutex; //标识临界变量是否可用
    private int full; //满缓冲区数目

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public boolean isMutex() {
        return mutex;
    }

    public void setMutex(boolean mutex) {
        this.mutex = mutex;
    }
}
