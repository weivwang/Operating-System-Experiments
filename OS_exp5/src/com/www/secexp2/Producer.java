package com.www.secexp2;

public class Producer extends Thread{
    Producer(Mutex mutex){
        this.mutex = mutex;
    }
    public Mutex mutex;

    public void p_pro(){
        //System.out.println("生产者进程：");
        if(mutex.getFull() < 20 && mutex.getFull() >= 0){
            if(mutex.isMutex()){
                System.out.println("消费者从缓冲区中取产品，生产者无法使用缓冲区，等待");
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }else {
                mutex.setMutex(true);
                mutex.setFull(mutex.getFull()+1);
                System.out.println("生产者生产完一件产品，已放入缓冲区，缓冲区产品数目："+mutex.getFull());
            }
        }else {
            System.out.println("仓库已经满，无法生产");
        }
    }

    public void v_pro(){
        mutex.setMutex(false);
    }

    public void run(){
        p_pro();
        v_pro();
    }
}
