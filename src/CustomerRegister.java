import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerRegister implements Serializable {


    ArrayList<Customer> customers = new ArrayList<>();


    public Customer getCustomer(int id){
        for(int i = 0; i < customers.size(); i++){
            Customer c = customers.get(i);
            if( c.id == id )
                return c;
        }
        return null;
    }


    public void addCustomer(Customer customer) {

        customers.add(customer);
    }

    @Override
    public String toString() {
        return "Customer Register" + "\n" + "Customers:" + "\n" + customers;
    }
}





