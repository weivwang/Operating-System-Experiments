package com.www.secexp2;

import javax.swing.plaf.TableHeaderUI;

public class Customer extends Thread {
    public Mutex mutex;
    Customer(Mutex mutex){
        this.mutex = mutex;
    }

    public void p_cus(){
        //System.out.println("消费者进程：");
        if(mutex.getFull() > 0){
            if(mutex.isMutex()){
                System.out.println("生产者向缓冲区存放产品，消费者无法使用缓冲区");
            }else{
                mutex.setMutex(true);
                mutex.setFull(mutex.getFull()-1);
                System.out.println("消费者消费一件产品，当前缓冲区产品剩余："+mutex.getFull());
            }
        }else {
            System.out.println("当前缓冲区无产品，消费者无法消费产品");
        }
    }
    public void v_cus(){
        mutex.setMutex(false);
    }
    public void run(){
        p_cus();
        v_cus();
    }

}
