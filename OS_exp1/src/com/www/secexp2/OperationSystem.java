package com.www.secexp2;

import java.util.*;

public class OperationSystem {

    public static void setPriorityAndName(PCB[] pcbs){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入进程优先数和运行时间：");
        for(int i = 1;i<= pcbs.length;i++){
            System.out.print("P"+i+"优先数:");
                pcbs[i-1].setPriority_level(scanner.nextInt());
            System.out.print("P"+i+"运行时间:");
            pcbs[i-1].setTime(scanner.nextInt());
        }
    }
    public static void showPCB(PCB[] pcbs){
        System.out.println("进程名  "+ "要求运行时间  "+"优先数  "+"状态");
        for(int i=1;i<=pcbs.length;i++){
            System.out.println(pcbs[i-1].getProcess_name()+"      "+pcbs[i-1].getTime()+"         "+pcbs[i-1].getPriority_level()+"     "+pcbs[i-1].getStatus());
        }
    }
    public static void sortByPriority(PCB[] pcbs){
        Collections.sort(Arrays.asList(pcbs),new Comparator<PCB>() {
            @Override
            public int compare(PCB o1, PCB o2) {
                return o2.getPriority_level() - o1.getPriority_level();
            }
        });
    }
    public static boolean checkPCB(PCB[] pcbs){
        for(int i=0;i<pcbs.length;i++){
            if(pcbs[i].getStatus() != 'E' && pcbs[i].getTime() != 0)
                return true;
        }
        return false;
    }
    public static void runPCB(PCB[] pcbs){
        boolean isRun = true;
        while (isRun) {
            int i = 0;
            while(pcbs[i].getStatus() == 'E' && pcbs[i].time == 0){++i;}
            pcbs[i].setTime(pcbs[i].time - 1);
            pcbs[i].setPriority_level(pcbs[i].priority_level - 1);
            System.out.println(pcbs[i].getProcess_name() + "运行");
            if(pcbs[i].getTime() == 0){
                pcbs[i].setStatus('E');
            }
            sortByPriority(pcbs);
            showPCB(pcbs);
            isRun = checkPCB(pcbs);
        }
    }
    }


