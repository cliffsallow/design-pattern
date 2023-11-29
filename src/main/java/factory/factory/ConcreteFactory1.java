package factory.factory;

import factory.product.Product;
import factory.product.Product1;

/**
 * @author Qiu Tao
 * @description: TODO
 * @date 2023/11/29 1:08
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    public Product createProduct() {
        return new Product1();
    }
}
