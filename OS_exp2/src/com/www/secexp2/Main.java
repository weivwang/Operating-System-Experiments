package com.www.secexp2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //建分区表
        Scanner scanner = new Scanner(System.in);
        AllocationTable row1 = new AllocationTable(1,20,50);
        AllocationTable row2 = new AllocationTable(2,40,100);
        AllocationTable row3 = new AllocationTable(3,10,400);
        AllocationTable row4 = new AllocationTable(4,28,500);
        AllocationTable row5 = new AllocationTable(5,30,550);
        AllocationTable[] allocationTables = new AllocationTable[]{row1,row2,row3,row4,row5};
        System.out.println("初始时，分区表为：");
        OperationSystem.showAllocationTable(allocationTables);
        OperationSystem.requestMemory(allocationTables);
        OperationSystem.requestMemory(allocationTables);
        System.out.print("输入释放空间大小: ");
        int size = scanner.nextInt();
        System.out.print("输入释放空间开始地址: ");
        int start_address = scanner.nextInt();
        OperationSystem.requestFreeMemory(size, start_address, allocationTables);
        }
    }

