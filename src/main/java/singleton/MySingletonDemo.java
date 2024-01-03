package singleton;

import java.util.ArrayList;

/**
 * @author Qiu Tao
 * @description: 不同单例模式实现比较
 * @date 2024/1/3 0:42
 */
public class MySingletonDemo {
    public static final int threadNum = 1000;
    public static void main(String[] args) throws InterruptedException {
        testSingleton1();

    }

    public static void testSingleton1() throws InterruptedException {
        long start = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();
        // todo 使用CountDownLatch或者CyclicBarrier让线程同时开始

        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(() -> {
                Singleton1 instance = Singleton1.getInstance();
            });
            threads.add(thread);
            thread.start();
        }
        for (int i = 0; i < threadNum; i++) {
            threads.get(i).join();
        }
        long end = System.currentTimeMillis();
        System.out.println("testSingleton1 耗时：" + (end - start));
    }


}

