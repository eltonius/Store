import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {

    //Oanvända eller felaktiga metoder
    //    static int count = 1;
    //    int id;
    // static AtomicInteger nextId = new AtomicInteger();
    // private int id;
    //    AtomicInteger atomicInteger = new AtomicInteger(0);
    //        this.id = count++;
    //id = nextId.incrementAndGet();
    //  addNewProduct = new ShoppingCart(new Customer(name, city, id));

    private String name;
    private String lastname;
    private String city;
    Product product;
    public static int count = 1;
    int id;
    ShoppingCart addNewProduct;
    ArrayList<Product> shoppingCartList = new ArrayList<>();

    //Konstruktor - this är en referens till objektet vi skapar -
    public Customer (String name, String lastname, String city, int id) {

        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.id = id;
        //shoppingCartList = new ArrayList<>();

    }

    //Getters - return the type of the variable
    public int getId() {
        return id++;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getLastname() {
        return lastname;
    }

    //Setters - takes one argument of the variable type
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return  "\n" + "Customer id: " + id + "\n" + "Name: "  + name + " " + lastname + "\n" + "City: " + city + "\n";
    }

    }
