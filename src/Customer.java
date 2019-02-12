import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {


    private String name;
    private String city;
    Product product;
//    AtomicInteger atomicInteger = new AtomicInteger(0);
    static int count = 1;
    int id;
    ShoppingCart addNewProduct;
    ArrayList<Product> customerList = new ArrayList<Product>();

//    static int count = 1;
//    int id;

   // static AtomicInteger nextId = new AtomicInteger();
   // private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Customer (String name, String city, int id) {

        this.name = name;
        this.city = city;
        this.id = count++;
//        this.id = count++;
        //id = nextId.incrementAndGet();


      //  addNewProduct = new ShoppingCart(new Customer(name, city, id));
    }

    @Override
    public String toString() {
        return  "\n" + "Customer id: " + id + "\n" + "Name: "  + name + "\n" + "City: " + city + "\n";
    }





    }
