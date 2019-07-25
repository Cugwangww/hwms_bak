package com.learning.sync;

/**
 * @Author wwwang7
 * @Date 2019/6/7 13:30
 * Synchronized 对象锁(方法锁默认this当前对象,同步代码块锁) 同一个对象.
 */
public class ObjectSync implements Runnable{

    private static ObjectSync s1 = new ObjectSync();

    /**
     * 方法锁
     */
   @Override
    public void run() {
       method();
    }

    public synchronized  void method(){
        System.out.println("当前线程执行名称."+Thread.currentThread().getName()+"  is starting ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程执行名称."+Thread.currentThread().getName()+"    is finished ");
    }

    /**
     * 同步代码块锁
     */
    /*@Override
    public void run() {
        synchronized(this){
            System.out.println("当前线程执行名称." + Thread.currentThread().getName() + "  is starting ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程执行名称." + Thread.currentThread().getName() + "    is finished ");
        }
    }*/

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        t1.start();
        t2.start();
        while (t1.isAlive()||t2.isAlive()){

        }
        System.out.println("################finished!!!!!!!!!!!!!!!!");
    }
}
