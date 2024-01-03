package singleton;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author Qiu Tao
 * @description: 不同单例模式实现比较
 * @date 2024/1/3 0:42
 */
public class MySingletonDemo {
    public static final int THREAD_NUM = 1000;
    public static void main(String[] args) throws InterruptedException {
        testSingleton1();

    }

    // todo 待更新测试方式
    public static void testSingleton1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);
        CountDownLatch latch1 = new CountDownLatch(THREAD_NUM);
//        long start = System.currentTimeMillis();
        // 使用CountDownLatch 让所有线程同时执行

        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread = new Thread(() -> {
                try {
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
                    Singleton1 instance = Singleton1.getInstance();
                    latch1.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            latch.countDown();

        }
        // 等待所有线程执行完毕
        latch1.await();
        long end = System.currentTimeMillis();
        System.out.println("end: " + end);
//        System.out.println("testSingleton1 耗时：" + (end - start));
    }


}

