package com.www.secexp2;

import java.util.ArrayList;
import java.util.Scanner;

public class OperationSystem {

    public static void showAllocationTable(AllocationTable[] allocationTables) {
        System.out.println("分区号  " + "大小  " + "起始地址");
        for (int i = 0; i < allocationTables.length; i++) {
            System.out.println(allocationTables[i].getPartition_number() + "      " + allocationTables[i].getSize() + "      " + allocationTables[i].getStart_address());
        }
    }

    public static void requestMemory(AllocationTable[] allocationTables) {
        System.out.println("输入请求内存大小(单位：K）：");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        boolean is_enough = false;
        int i=0;
        for (i=0; i < allocationTables.length; i++) {
            if (allocationTables[i].getSize() >= size) {
                is_enough = true;
                allocationTables[i].setSize(allocationTables[i].getSize() - size);
                break;
            }
        }
        if(is_enough){
            System.out.println("请求内存成功"+"分配的分区号为："+ (i+1));
            System.out.println("分配后的分区表为：");
            OperationSystem.showAllocationTable(allocationTables);
        }else {
            System.out.println("内存空间不足，无法分配");
        }
    }

    public static void requestFreeMemory(int size, int start_address, AllocationTable[] allocationTable) {
        for (int i = 1; i < allocationTable.length; i++) {
            if (start_address == allocationTable[i - 1].start_address + allocationTable[i - 1].getSize() && start_address + size == allocationTable[i].start_address) {
                AllocationTable row = new AllocationTable(i, allocationTable[i - 1].getSize() + allocationTable[i].getSize() + size, allocationTable[i - 1].start_address);
                AllocationTable[] new_allocationTable = new AllocationTable[allocationTable.length - 1];
                for (int j = 0; j < new_allocationTable.length; j++) {
                    if (j == i-1) {
                        new_allocationTable[j] = row;
                    }
                    if (j < i-1) {
                        new_allocationTable[j] = allocationTable[j];
                    }
                    if (j > i-1) {
                        new_allocationTable[j] = allocationTable[j + 1];
                        new_allocationTable[j].partition_number -= 1;
                    }
                }
                System.out.println("回收空间成功");
                showAllocationTable(new_allocationTable);
                break;
            } else if (start_address == allocationTable[i - 1].start_address + allocationTable[i - 1].getSize() && start_address + size < allocationTable[i].start_address) {
                allocationTable[i - 1].setSize(allocationTable[i - 1].getSize() + size);
                showAllocationTable(allocationTable);
                break;
            } else if (start_address > allocationTable[i - 1].start_address + size && start_address + size == allocationTable[i].start_address) {
                allocationTable[i].setSize(allocationTable[i].getSize() + size);
                System.out.println("回收空间成功");
                showAllocationTable(allocationTable);
                break;
            } else if (start_address > allocationTable[i - 1].start_address + allocationTable[i - 1].getSize() && start_address < allocationTable[i].start_address) {
                AllocationTable row = new AllocationTable(i+1,size,start_address);
                AllocationTable[] new_allocationTable = new AllocationTable[allocationTable.length+1];
                for (int j=0;j<new_allocationTable.length;j++){
                    if(j < i){
                        new_allocationTable[j] = allocationTable[j];
                    }
                    if(j==i){
                        new_allocationTable[j] = row;
                    }
                    if(j >i){
                        new_allocationTable[j] = allocationTable[j-1];
                        new_allocationTable[j].partition_number += 1;
                    }
                }
                System.out.println("回收空间成功");
                showAllocationTable(new_allocationTable);
                break;
            }else{
                continue;
            }

        }

        }
}
