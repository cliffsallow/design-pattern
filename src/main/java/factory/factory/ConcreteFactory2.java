package factory.factory;

import factory.product.Product;
import factory.product.Product2;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2023/11/29 1:09
 */
public class ConcreteFactory2 extends AbstractFactory{
    @Override
    public Product createProduct() {
        return new Product2();
    }
}
