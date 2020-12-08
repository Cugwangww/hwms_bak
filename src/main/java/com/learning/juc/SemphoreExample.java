package com.learning.juc;

import java.util.concurrent.*;

/**
 * @Author wwwang7
 * @Date 2019/6/13 21:34
 */
public class SemphoreExample {

    private final static int threadNum = 20;

    public static void main(String[] args) throws Exception{
        final ExecutorService es = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        for(int i =0;i<threadNum;i++){
            final int num = i;
            es.execute(() -> {
                try{
                    if (semaphore.tryAcquire(5000,TimeUnit.MILLISECONDS)){
                        test(num);
                        semaphore.release();
                    }
                }catch (Exception e){
                }
            });
        }
        System.out.println("finished!!!!");
    }

    private static void test(int countNum) throws Exception{
        Thread.sleep(1000);
        System.out.println("num:"+countNum);
        System.out.println("time:"+System.currentTimeMillis());
    }
}
