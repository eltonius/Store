import java.io.Serializable;
import java.util.ArrayList;

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

    @Override
    public String toString() {
        return "Product Regrister" + "\n" + "Products: " + products;
    }
}