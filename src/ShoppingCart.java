import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {


    private final Customer customer;
    ArrayList<Customer> costumer;
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<String> orderList;


    ShoppingCart(Customer customer) {

        this.customer = customer;
        costumer = new ArrayList<>();
        orderList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ShoppingCart" + "\n" + "Customer: " + customer + "\n" + " Products: " + "\n"  + products;
    }
}