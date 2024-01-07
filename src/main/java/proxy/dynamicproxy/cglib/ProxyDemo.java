package proxy.dynamicproxy.cglib;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2024/1/8 0:48
 */
public class ProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        RealSubject proxySubject = new ProxyFactory(realSubject).getProxySubject();
        proxySubject.publicAction();
        proxySubject.protectedAction();
        proxySubject.publicFinalAction(); // todo 被代理对象中的final方法会被执行，但是不会执行代理类中invoke前后的操作

    }
}
