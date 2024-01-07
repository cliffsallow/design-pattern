package proxy.dynamicproxy.jdk;

/**
 * @description: 公共接口
 * @author Qiu Tao
 * @date 2024/1/6 0:51
 */
public interface ISubject {
    void action1();

    void action2();

    default void defaultAction(){
        System.out.println("默认方法");
    }
}
