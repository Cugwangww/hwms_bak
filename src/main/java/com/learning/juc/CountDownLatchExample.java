package com.learning.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wwwang7
 * @Date 2019/6/13 21:34
 */
public class CountDownLatchExample {

    private final static int threadNum = 50;

    public static void main(String[] args) throws Exception{
        final ExecutorService es = Executors.newCachedThreadPool();
        final CountDownLatch cdl = new CountDownLatch(threadNum);
        for(int i =0;i<50;i++){
            final int num = i;
            es.execute(() -> {
                try{
                    test(num);
                }catch (Exception e){
                }finally {
                    cdl.countDown();
                }
            });
        }
        cdl.await(10, TimeUnit.MILLISECONDS);
        System.out.println("finished!!!!");
    }

    private static void test(int countNum) throws Exception{
        Thread.sleep(100);
        System.out.println("num:"+countNum);
    }
}
