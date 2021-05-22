package com.www.secexp2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationSystem {
    public static void showProcessTable(Process process){
        System.out.println("页号   块号");
        for (int i = 0; i < process.getSize(); i++) {
            System.out.print(i+"       ");
            System.out.println(process.getBlocktable().get(i));
        }
    }
    public static void showBitmap(int[][] bitmap){
        System.out.println("位示图如下：");
        System.out.print("  ");
        for (int i = 0;i<8;i++){
            System.out.print(i+" ");
        }
        System.out.println(" ");
        for (int i = 0; i < 8; i++) {
            System.out.print(i+" ");
            for(int j= 0;j<8;j++){
                System.out.print(bitmap[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    public static void allocationMemory(int[][] bitmap,ArrayList<Process> processArrayList){
        int cnt = 0;
        String processname;
        int size;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入进程名：");
        processname = scanner.next();
        System.out.print("输入请求大小：");
        size = scanner.nextInt();
        Process process = new Process();
        process.setName(processname);
        process.setSize(size);
        boolean ok = false;
        int i = 0;
        int j = 0;
        for(;i<8;i++){
            for(;j<8;j++){
                if(bitmap[i][j] == 0){
                bitmap[i][j] = 1;
                process.blocktable.add(8*i + j +1);
                ++cnt;
                }
                if(cnt >= size){
                    ok = true;
                    break;
                }
            }
            if(cnt >= size){
                ok = true;
                break;
            }else {
                j=0;
            }

        }
        if(ok){
            System.out.println("分配成功，该进程的页表：");
            processArrayList.add(process);
            showProcessTable(process);
        }
        else {
            System.out.println("内存不够");
            int newcnt = 0;
            for(int k = 7;k>=0;k--){
                for (int m = 7;m>=0;m--){
                    bitmap[k][m] = 0;
                    newcnt++;
                    if (newcnt >= cnt){
                        break;
                    }
                }
                if (newcnt >= cnt){
                    break;
                }
            }
        }

    }

    public static void FreeProcess(int[][] bitmap,ArrayList<Process> processArrayList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入要释放的进程名：");
        String processname = scanner.next();
        for (int i = 0; i < processArrayList.size(); i++) {
            int cnt = 0;
            if(processArrayList.get(i).getName().equals(processname)){
                int j = (processArrayList.get(i).getBlocktable().get(0) - 1) % 8;
                int k = (processArrayList.get(i).getBlocktable().get(0) - 1) / 8;
                boolean is_ok = false;
                for(;k<8;k++){
                    for(;j<8;j++){
                        if(cnt < processArrayList.get(i).getSize()){
                            ++cnt;
                            bitmap[k][j] = 0;
                        }
                        if(cnt >= processArrayList.get(i).getSize()){
                            is_ok = true;
                            break;
                        }
                    }
                    if(cnt >= processArrayList.get(i).getSize()){
                        is_ok = true;
                        break;
                    }
                    if(cnt >= processArrayList.get(i).getSize()) {
                        break;
                    }
                    else {
                        j=0;
                    }
                }
                if(is_ok){
                    System.out.println("回收成功，位示图如下：");
                    showBitmap(bitmap);
                }
            }
        }

    }
}
