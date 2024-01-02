package singleton;

/**
 * @author Qiu Tao
 * @description: 1. 懒汉式
 * @date 2024/1/3 0:07
 */
public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance() {
        return instance;
    }

}
/**
 * 饿汉式单例模式：
 * 优点
 *  1. 类加载时就初始化，没有线程安全问题
 *  2. 不用加锁
 * 缺点
 *  1. 没有延迟加载
 */
