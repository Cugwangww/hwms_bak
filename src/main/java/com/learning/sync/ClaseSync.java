package com.learning.sync;

/**
 * @Author wwwang7
 * @Date 2019/6/7 13:30
 * Synchronized 类锁 (static形式  .class形式) 同一个类,实例出来的多个对象.
 */
public class ClaseSync implements Runnable{

    private static ClaseSync s1 = new ClaseSync();
    private static ClaseSync s2 = new ClaseSync();

/*    @Override
    public void run() {
        method();
    }

    public static synchronized  void method(){
        System.out.println("当前线程执行名称."+Thread.currentThread().getName()+"  is starting ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程执行名称."+Thread.currentThread().getName()+"    is finished ");
    }*/

    /**
     * .class形式
     */
    @Override
    public void run() {
        synchronized(ClaseSync.class){
            System.out.println("当前线程执行名称." + Thread.currentThread().getName() + "  is starting ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程执行名称." + Thread.currentThread().getName() + "    is finished ");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        t1.start();
        t2.start();
        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.println("################finished!!!!!!!!!!!!!!!!");
    }
}
