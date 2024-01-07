package proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Qiu Tao
 * @description: 被代理对象关联的InvocationHandler
 * @date 2024/1/6 1:02
 */
public class MyInvocationHandler implements InvocationHandler {
    private final ISubject target;

    public MyInvocationHandler(ISubject target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理之前处理");
        Object result = method.invoke(target, args);
        System.out.println("jdk动态代理之后处理");
        return result;
    }
}
