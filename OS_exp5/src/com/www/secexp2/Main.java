package com.www.secexp2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Mutex mutex = new Mutex();
        mutex.setFull(0);
        mutex.setMutex(false); //缓冲区未被使用
        Random r = new Random();
        for(int i=0;i<300;i++){
            int num = r.nextInt(10);
            if(num >= 5){
                Customer c = new Customer(mutex);
                c.start();

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else{
                Producer p = new Producer(mutex);
                p.start();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
