package proxy.dynamicproxy.cglib;


/**
 * @author Qiu Tao
 * @description: 被代理类
 * @date 2024/1/8 0:40
 */
public class RealSubject {

    public void publicAction() {
        System.out.println("Execute RealSubject.publicAction");
    }

    public final void publicFinalAction() {
        System.out.println("Execute RealSubject.publicFinalAction");
    }

    public static void publicStaticAction() {
        System.out.println("Execute RealSubject.publicStaticAction");
    }

    protected void protectedAction() {
        System.out.println("Execute RealSubject.protectedAction");
    }

    private void privateAction() {
        System.out.println("Execute RealSubject.privateAction");
    }


}
