package proxy.staticproxy;

/**
 * @author Qiu Tao
 * @description: 代理类，将真实对象作为代理类的一个成员管理，重新实现被代理的方法
 * @date 2024/1/6 0:41
 */
public class RealSubjectProxy implements ISubject{
    private ISubject subject;

    public RealSubjectProxy(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action1() {
        System.out.println("代理类" + this.getClass().getSimpleName() +"执行了方法1之前的操作");
        subject.action1();
        System.out.println("代理类" + this.getClass().getSimpleName() +"执行了方法1之后的操作");
    }

    @Override
    public void action2() {
        System.out.println("代理类" + this.getClass().getSimpleName() +"执行了方法2之前的操作");
        subject.action2();
        System.out.println("代理类" + this.getClass().getSimpleName() +"执行了方法2之后的操作");
    }
}
