package proxy.dynamicproxy.jdk;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2024/1/8 0:03
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();
        ISubject proxySubject = new DynamicProxyFactory(realSubject).getProxySubject();
//        proxySubject.action1();
        proxySubject.defaultAction();

    }
}
