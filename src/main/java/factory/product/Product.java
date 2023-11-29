package factory.product;

public interface Product {
    int getColor();

    int getSize();

    default void getString(){
        System.out.println("color = " + getColor() + "; size = " + getSize());
    }
}
