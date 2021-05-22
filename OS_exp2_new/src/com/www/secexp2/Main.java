package com.www.secexp2;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] bitmap = new int[8][8];
        ArrayList<Process> processArrayList = new ArrayList<>();
        OperationSystem.allocationMemory(bitmap,processArrayList);
        OperationSystem.showBitmap(bitmap);
        OperationSystem.allocationMemory(bitmap,processArrayList);
        OperationSystem.showBitmap(bitmap);
        OperationSystem.allocationMemory(bitmap,processArrayList);
        OperationSystem.showBitmap(bitmap);
        OperationSystem.FreeProcess(bitmap,processArrayList);
        OperationSystem.allocationMemory(bitmap,processArrayList);
        OperationSystem.showBitmap(bitmap);
        OperationSystem.FreeProcess(bitmap,processArrayList);
    }
}
