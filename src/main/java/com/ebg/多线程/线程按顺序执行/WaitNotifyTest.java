package com.ebg.多线程.线程按顺序执行;

import com.ebg.多线程.SignEnum;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangweiwei22@hikvision.com.cn
 * @description
 * @date 2024/5/15
 */
public class WaitNotifyTest {
    /**
     * 锁
     */
    private final Object lock = new Object();
    /**
     * 当前符号
     */
    private volatile SignEnum currentSign = SignEnum.C;
    /**
     * 自定义线程池
     */
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors() * 2, 5, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(3), Thread::new, new ThreadPoolExecutor.AbortPolicy());

    /**
     * 打印
     */
    @Test
    @SneakyThrows
    public void testPrint() {
        // 打印B
        Future<?> bFuture = executor.submit(() -> doPrint(33, SignEnum.B));
        // 打印A
        Future<?> aFuture = executor.submit(() -> doPrint(34, SignEnum.A));
        // 打印C
        Future<?> cFuture = executor.submit(() -> doPrint(33, SignEnum.C));
        // 等待打印完成
        while (!aFuture.isDone() || !bFuture.isDone() || !cFuture.isDone()) {
            TimeUnit.MILLISECONDS.sleep(5);
        }
        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 执行打印
     *
     * @param count      次数
     * @param targetSign 目标符号
     */
    @SneakyThrows
    private void doPrint(int count, SignEnum targetSign) {
        synchronized (lock) {
            for (int index = 0; index < count; index++) {
                // 如果当前符号为目标符号的上一个符号，执行打印符号
                if (Objects.equals(targetSign.last(), currentSign)) {
                    // 打印目标符号
                    System.out.print(targetSign.name());
                    // 打印分割符，方便观察
                    if (Objects.equals(SignEnum.C, targetSign)) {
                        System.out.print("|");
                    }
                    // 切换当前符号
                    currentSign = targetSign;
                    // 释放锁，通知其他线程
                    // 不能使用notify，如果通知的某个线程不符合条件，进行等待，将会造成程序阻塞
                    lock.notifyAll();
                }
                // 不匹配的话，index回退，同时进行等待
                else {
                    index--;
                    lock.wait();
                }
            }
        }
    }
}
