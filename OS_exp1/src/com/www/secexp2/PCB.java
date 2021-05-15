package com.www.secexp2;

public class PCB{
    public String process_name; //进程名
    public PCB pointer; //指针
    public int time; //运行时间
    public int priority_level; //进程优先数
    public char status = 'R'; //进程状态，R表示就绪，E表示结束

    public PCB(String process_name){
        this.process_name = process_name;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getPriority_level() {
        return priority_level;
    }

    public void setPriority_level(int priority_level) {
        this.priority_level = priority_level;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public PCB getPointer() {
        return pointer;
    }

    public void setPointer(PCB pointer) {
        this.pointer = pointer;
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }
}
