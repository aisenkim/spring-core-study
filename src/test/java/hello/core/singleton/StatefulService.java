package hello.core.singleton;

/**
 * Constructed in a stateful way to show why this
 * is not a good idea
 */
public class StatefulService {
    private int price; // not a good idea to use a global variable

    public void order(String name, int price) {
        System.out.println("name = " + name + "price: " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
