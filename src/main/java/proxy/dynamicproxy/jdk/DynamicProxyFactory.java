package proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author Qiu Tao
 * @description: 通用代理工厂
 * @date 2024/1/6 1:03
 */
public class DynamicProxyFactory {
    private ISubject target;

    public DynamicProxyFactory(ISubject target) {
        this.target = target;
    }

    public ISubject getProxySubject() {
        return (ISubject) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }

}
