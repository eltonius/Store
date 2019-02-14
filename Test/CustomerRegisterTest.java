import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRegisterTest {


    @Test
    void checksToSeeIfMethod_addCustomer_Works() {

        CustomerRegister customerRegister = new CustomerRegister();

        int start = customerRegister.customers.size();

        customerRegister.addCustomer(new Customer("Name", "Lastname", "City", 20));

        assertEquals(start + 1, customerRegister.customers.size());

    }


    @Test
    void checksToSeeIfMethod_getCustomer_Works() {

;
    }

}