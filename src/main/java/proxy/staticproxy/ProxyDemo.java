package proxy.staticproxy;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2024/1/6 0:46
 */
public class ProxyDemo {
    public static void main(String[] args) {
        ISubject realSubject = new RealSubject();
        RealSubjectProxy realSubjectProxy = new RealSubjectProxy(realSubject);
        realSubjectProxy.action1();
    }
}
