package factory;

import factory.factory.AbstractFactory;
import factory.factory.ConcreteFactory1;
import factory.factory.ConcreteFactory2;
import factory.product.Product;
import factory.product.Product1;
import factory.product.Product2;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2023/11/29 1:19
 */
public class MyFactoryDemo {
    public static void main(String[] args) throws Exception {
        int productNo = 2;
        MyFactoryDemo factoryDemo = new MyFactoryDemo();
        factoryDemo.getProduct(productNo).getString();

    }

    public Product getProduct(int productNo) throws Exception {
        AbstractFactory abstractFactory;
        switch (productNo) {
            case 1: {
                abstractFactory = new ConcreteFactory1();
                return abstractFactory.createProduct();
            }
            case 2: {
                abstractFactory = new ConcreteFactory2();
                return abstractFactory.createProduct();
            }
            default: throw new Exception("不存在对应类型的产品");
        }
    }
}
