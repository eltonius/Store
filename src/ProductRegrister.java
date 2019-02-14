import org.w3c.dom.css.Counter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductRegrister implements Serializable {

    ArrayList<Product> products = new ArrayList<>();

    public void addNewProduct(Product product) {

        products.add(product);
    }

    public Product getProduct(int id){
        for(int i = 0; i < products.size(); i++){
            Product p = products.get(i);
            if( p.productID == id )
                return p;
        }
        return null;
    }

    /* Map<String, long> map = products.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); */

    @Override
    public String toString() {
        return "Product Regrister" + "\n" + "Products: " + products + "\n";
    }
}