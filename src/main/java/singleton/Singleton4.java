package singleton;

/**
 * @author Qiu Tao
 * @description: 4. 静态内部类 实现单例模式
 * @date 2024/1/3 0:31
 */
public class Singleton4 {
    private Singleton4() {}

    private static class SingletonHolder {
        public static final Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }
}
/**
 * Java静态内部类特点：
 * 1. 当外部类被加载时，静态内部类不会被加载进内存；只有使用到内部类时才会被加载
 * 2. 类的静态成员在第一次类加载时就会被初始化，而且只会被加载一次
 *
 * 静态内部类 实现单例模式：
 * 优点
 *  1. 实现了延迟加载
 *  2. 线程安全
 *  3. 不需要加锁，线程安全和instance唯一性都有JVM保证
 */
