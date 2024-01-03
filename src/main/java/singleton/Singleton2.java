package singleton;

/**
 * @author Qiu Tao
 * @description: 2. 饱汉式
 * @date 2024/1/3 0:13
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
/**
 * 饱汉式单例模式：
 * 优点
 *  1. 实现了延迟加载，
 *  2. 使用synchronized保证了线程安全
 * 缺点
 *  1. 锁粒度较大，影响并发度
 */
