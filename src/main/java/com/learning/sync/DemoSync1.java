package com.learning.sync;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author wwwang7
 * @Date 2019/6/7 13:30
 * Synchronized 能够保证在同一时刻最多只有一个线程执行该代码,以保证并发效果的安全.
 */
public class DemoSync1 implements Runnable{

    private  static DemoSync1 s1 = new DemoSync1();
    private  static DemoSync1 s2 = new DemoSync1();
    private static int a  = 0 ;
    @Override
    public void run() {
        for(int i = 0;i<1000000;i++){
            a++;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("################finished!!!!!!!!!!!!!!!!");
        System.out.println(a);
    }
}
