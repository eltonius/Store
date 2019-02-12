import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {


    private final Customer customer;
    ArrayList<Customer> costumer = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<String> orderList = new ArrayList<>();

//    public ShoppingCart(Customer customer) {
//    }

    ShoppingCart(Customer customer) {

        this.customer = customer;
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