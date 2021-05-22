package com.www.secexp2;

import java.util.ArrayList;
import java.util.Scanner;

public class OperationSystem {
    public static void showAllocationTable(ArrayList<AllocationTable> allocationTables){
        System.out.println("序号  "+ "起始空闲块号  " +"空闲块个数  " + "状态 ");
        for (int i = 0; i < allocationTables.size(); i++) {
            int num = allocationTables.get(i).getNumber();
            int startblocknum = allocationTables.get(i).getStartfreeblocknumber();
            int blocknum = allocationTables.get(i).getBlocknum();
            char status = allocationTables.get(i).getStatus();
            System.out.println(" "+num+"         "+ startblocknum +"         "+blocknum+"       "+status);
        }
    }

    public static void showFileList(ArrayList<File> fileArrayList){
        System.out.println("文件名 "+ "文件大小 " + "起始块号 "+ "物理理记录号 "+"磁道号 "+"柱面号");
        for (int i = 0; i < fileArrayList.size(); i++) {
            String filename = fileArrayList.get(i).getFilename();
            int size = fileArrayList.get(i).getFilesize();
            int start = fileArrayList.get(i).getStartblock();
            int physical = fileArrayList.get(i).getPhysicalrecord();
            int track = fileArrayList.get(i).getTrack();
            int cylinder = fileArrayList.get(i).getCylinder();
            System.out.println(filename+"     "+size+"      "+start+"        "+physical+"      "+track+"       "+cylinder);

        }
    }

    public static void requestMemory(ArrayList<AllocationTable> allocationTables,ArrayList<File> fileArrayList){
        Scanner scanner = new Scanner(System.in);
        File file = new File();
        System.out.print("输入文件名：");
        file.setFilename(scanner.next());
        System.out.print("输入文件需要的空闲块：");
        file.setFilesize(scanner.nextInt());
        boolean is_enough = false;
        int i;
        for (i = 0; i < allocationTables.size(); i++) {
            if(allocationTables.get(i).getBlocknum() >= file.getFilesize()) {
                is_enough = true;
                allocationTables.get(i).setBlocknum(allocationTables.get(i).getBlocknum() - file.getFilesize());
                file.setNum(i+1);
                file.setPhysicalrecord(allocationTables.get(i).getStartfreeblocknumber() % 6);
                file.setTrack((allocationTables.get(i).getStartfreeblocknumber()/6) % 20);
                file.setCylinder(allocationTables.get(i).getStartfreeblocknumber()/6/20);
                allocationTables.get(i).setStartfreeblocknumber(allocationTables.get(i).getStartfreeblocknumber() + file.getFilesize());
                break;
            }
        }
        if(is_enough){
            fileArrayList.add(file);
            System.out.println("分配成功，分配的起始块号为："+(allocationTables.get(i).getStartfreeblocknumber() - file.getFilesize()));
            System.out.println("磁盘上，起始物理记录号为："+file.getPhysicalrecord() + ","+"磁道号："+file.getTrack()+" ,"+"柱面号"+file.getCylinder());
        }
        else {
            System.out.println("分配不成功");
        }
    }
    public static void freeMemory(ArrayList<AllocationTable> allocationTables,ArrayList<File> fileArrayList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入需要释放的文件名: ");
        String filename = scanner.next();
        boolean delete_ok = false;
        for (int i = 0; i < fileArrayList.size(); i++) {
            if(fileArrayList.get(i).getFilename().equals(filename)){
                int j = fileArrayList.get(i).getNum() - 1;
                allocationTables.get(j).setStartfreeblocknumber(allocationTables.get(j).getStartfreeblocknumber() - fileArrayList.get(i).getFilesize());
                allocationTables.get(j).setBlocknum(allocationTables.get(j).getBlocknum() + fileArrayList.get(i).getFilesize());
                System.out.println("删除文件成功");
                System.out.println("删除文件的起始空闲号为："+allocationTables.get(j).getStartfreeblocknumber());
                fileArrayList.remove(i);
                delete_ok = true;
                break;
            }
        }
        if(!delete_ok){
            System.out.println("删除失败，没有找到文件");
        }

    }
}
