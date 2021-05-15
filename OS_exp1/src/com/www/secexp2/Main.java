package com.www.secexp2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<PCB> queue = new LinkedList<>();
        PCB P1 = new PCB("P1");
        PCB P2 = new PCB("P2");
        PCB P3 = new PCB("P3");
        PCB P4 = new PCB("P4");
        PCB P5 = new PCB("P5");
        PCB[] pcbs = new PCB[]{P1,P2,P3,P4,P5};
        OperationSystem.setPriorityAndName(pcbs);
        OperationSystem.showPCB(pcbs);
        OperationSystem.sortByPriority(pcbs);
        System.out.println("按照优先数排序后：");
        OperationSystem.showPCB(pcbs);
        OperationSystem.runPCB(pcbs);
        }

}
