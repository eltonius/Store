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

    //Vet inte om detta är rätt metod? Blev förvirrad, vet inte vad jag har gjort haha...
    @Test
    void checksToSeeIfMethod_getCustomer_Works() {

        CustomerRegister customerRegister = new CustomerRegister();

        Customer id = customerRegister.getCustomer(3);

        customerRegister.getCustomer(3);

        assertEquals(id, customerRegister.getCustomer(3));
    }

}