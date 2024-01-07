package proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Qiu Tao
 * @description: 使用cglib实现动态代理
 * cglib 是一个比较早期的社区包，基于 asm 包在运行时生成字节码，和上面谈到的jdk动态代理背后的思路是比较类似的。
 * 有差异的地方在于，它动态生成的类是继承与被代理类的，这样就可以解决因为没有实现接口而无法使用动态代理的问题，
 * 当然因为它背后是继承，那么同时也带来了几个问题：
 *
 * 被修饰为 final 的类无法被代理
 * 被修饰为 final 的类方法代理会失效
 *
 * @date 2024/1/8 0:38
 */
public class ProxyFactory implements MethodInterceptor {
    private final RealSubject target;

    public ProxyFactory(RealSubject target) {
        this.target = target;
    }

    public RealSubject getProxySubject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (RealSubject) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB动态代理 before method");
        Object result = method.invoke(target, args);
        System.out.println("CGLIB动态代理 after method");
        return result;
    }
}
