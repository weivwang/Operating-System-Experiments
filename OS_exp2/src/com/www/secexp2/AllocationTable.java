package com.www.secexp2;

public class AllocationTable {
    public int partition_number; //
    public int size;
    public int start_address;

    public AllocationTable(int partition_number,int size,int start_address){
        this.partition_number = partition_number;
        this.size = size;
        this.start_address = start_address;
    }

    public int getStart_address() {
        return start_address;
    }

    public void setStart_address(int start_address) {
        this.start_address = start_address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPartition_number() {
        return partition_number;
    }

    public void setPartition_number(int partition_number) {
        this.partition_number = partition_number;
    }
}
