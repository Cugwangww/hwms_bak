package com.learning.model.singleton;

/**
 * @description 单例模式双重校验锁 double-checked locking
 * instance = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
 * 1.给 instance 分配内存
 *2.调用 Singleton 的构造函数来初始化成员变量
 * 3.将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
 * @date 2021/9/18
 */
public class Singleton {

    /**
     * volatile修饰禁止指令重排序
     */
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
