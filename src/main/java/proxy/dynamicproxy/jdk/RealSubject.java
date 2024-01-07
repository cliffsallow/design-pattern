package proxy.dynamicproxy.jdk;

/**
 * @author Qiu Tao
 * @description: 被代理类
 * @date 2024/1/6 0:40
 */
public class RealSubject implements ISubject {
    @Override
    public void action1() {
        System.out.println("Execute RealSubject.action1");
    }

    @Override
    public void action2() {
        System.out.println("Execute RealSubject.action2");
    }
}
