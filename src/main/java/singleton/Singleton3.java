package singleton;

/**
 * @author Qiu Tao
 * @description: 3. 双重检查锁
 * @date 2024/1/3 0:21
 */
public class Singleton3 {
    public static volatile Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (instance == null) { // 避免每次都进入同步块，降低性能开销
            synchronized (Singleton3.class) {
                if (instance == null) { // 避免重复创建
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}
/**
 * 双重检查锁单例模式：
 * 优点
 *  1. 实现了延迟加载
 *  2. 使用synchronized保证了线程安全
 *
 */

