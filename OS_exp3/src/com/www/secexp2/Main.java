package com.www.secexp2;

import java.util.AbstractList;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AllocationTable row1 = new AllocationTable(1,5,6,'F');
        AllocationTable row2 = new AllocationTable(2,14,3,'F');
        AllocationTable row3 = new AllocationTable(3,21,30,'F');
        ArrayList<AllocationTable> allocationArrayList = new ArrayList<>();
        allocationArrayList.add(row1);
        allocationArrayList.add(row2);
        allocationArrayList.add(row3);
        ArrayList<File> fileArrayList = new ArrayList<>();
        OperationSystem.showAllocationTable(allocationArrayList);
        OperationSystem.requestMemory(allocationArrayList,fileArrayList);
        OperationSystem.showAllocationTable(allocationArrayList);
        OperationSystem.showFileList(fileArrayList);
        OperationSystem.requestMemory(allocationArrayList,fileArrayList);
        OperationSystem.showAllocationTable(allocationArrayList);
        OperationSystem.showFileList(fileArrayList);
        OperationSystem.freeMemory(allocationArrayList,fileArrayList);
        OperationSystem.showAllocationTable(allocationArrayList);
        OperationSystem.showFileList(fileArrayList);

    }
}
