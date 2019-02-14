import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String type;
    private String unit;
    private int price;
    private static int productCount = 1;
    int productID; //deklarerar en variabel som heter productID

    //Konstruktor
    public Product(String name, String type, String unit, Integer price) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.unit = unit;
        this.productID = ++productCount;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }

    public int getPrice() {
        return price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public static int getProductCount() {
//        return ++productCount;
//    }
//
//    public static void setProductCount(int productCount) {
//        Product.productCount = productCount;
//    }
//
//    public int getProductID() {
//        return productID;
//    }
//
//
//    public void setProductID(int productID) {
//        this.productID = productID;
//    }
//


    @Override
    public String toString() {

        return "\n" + "Product ID: " + productID + "\n" + "Product name: " + name + "\n" + "Category: " + type + "\n"
                + "Price: " + price + "kr" + " " +  unit + " " + "per piece/kg/l" + "\n";

    }
}
