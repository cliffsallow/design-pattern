package proxy.dynamicproxy.jdk;

/**
 * @author Qiu Tao
 * @description: 被代理的类必须实现接口，才能基于 JDK Proxy API 实现动态代理，
 * 当我们需要对二方或者三方提供的类实现代理的话，这将是个不小的限制。
 * Proxy API 背后的原理是基于我们传入 interfaces，
 * 动态创建了一个继承 Proxy 类并实现了我们提供的 interfaces 的类的字节码，
 * 并通过我们传入的 classLoader 将这个类加载进来
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
