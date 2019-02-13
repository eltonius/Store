import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRegristerTest {

    @Test
    void checkToSeeIf_addNewProduct_Works() {

        ProductRegrister productRegrister = new ProductRegrister();

        int start = productRegrister.products.size();

        productRegrister.addNewProduct(new Product("Name", "Drink", "1", 20));

        assertEquals(start + 1, productRegrister.products.size());

    }
}