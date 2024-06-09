package com.多线程.线程按顺序执行;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/5/22
 */
public class JoinTest {

    public static void main(String[] args) {
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() { System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

                // 引用t1线程，等待t1线程执行完
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2");
            }

        });




        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() { try {
            // 引用t2线程，等待t2线程执行完
                t2.join();
            } catch (InterruptedException e) { e.printStackTrace();
            }
                System.out.println("t3");
            }
        });
        t2.start();//这里三个线程的启动顺序可以任意，大家可以试下！ t2.start();
        t1.start();//这里三个线程的启动顺序可以任意，大家可以试下！ t2.start();
        t3.start();//这里三个线程的启动顺序可以任意，大家可以试下！ t2.start();
    }
}
