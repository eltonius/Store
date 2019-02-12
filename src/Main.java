import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static javax.swing.UIManager.getInt;

public class Main {

    static Scanner input = new Scanner(System.in);
    private static Object getString;
    private static CustomerRegister customerRegister;
    private static ProductRegrister productRegrister;

    private static Object Customer;
   static ShoppingCart sc = new ShoppingCart((Customer) Customer);
    static CustomerRegister cr = new CustomerRegister();
    static ProductRegrister pr = new ProductRegrister();
//    static AtomicInteger atomicInteger = new AtomicInteger(0);
    static int id;
    private static Object CustomerRegister;
    private Scanner scanner;
    private int productID;
    private Object String;
    private Object ShoppingCart;
    private Object ArrayList;


    public static void main(String[] args) throws IOException {

        Main mainObject = new Main();
        mainObject.restoreSettings();


        while (true) {
            System.out.println(" ");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("* Welcome to the Store - Please choose an option *");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println(" ");
            System.out.println("1. Create new customer");
            System.out.println("2. Search for customer and added products");
            System.out.println("3. Add new product to store");
            System.out.println("4. Customerlist");
            System.out.println("5. Productlist");
            System.out.println("6. Finish and save");
            System.out.println("0. Exit and leave");

            switch (readNumber()) {
                case 0:
                    System.out.println("Welcome back next time");
                    mainObject.finishAndSave();
                    return;
                case 1:
                    mainObject.createNewCustomer();
                    break;
                case 2:
                    mainObject.searchForCustomer();
                    break;
                case 3:
                    mainObject.addNewProduct();
                    break;
                case 4:
                    mainObject.customerList();
                    break;
                case 5:
                    mainObject.productList();
                    break;
                case 6:
                    mainObject.finishAndSave();
                    break;
                default:
                    System.out.println("Option not available!");
            }
        }

    }

    private void productList() {
        System.out.println(pr.products);
    }

    private void customerList() {

        System.out.println(cr.customers +  " " + pr.products);

    }


    private void searchForCustomer() {

        System.out.println("Enter customerID:");
        int chosenId = input.nextInt();
        int id = chosenId;
        Customer customer = cr.getCustomer(id);
//        System.out.println(customer);
//        System.out.println(customer.customerList.toString());

        float totalPrice = 0;

        for(Product product:customer.customerList) {
            totalPrice += product.getPrice();

        }
       System.out.println("Total price: " + totalPrice);

                try {
            System.out.println(cr.getCustomer(id));

        } catch (IndexOutOfBoundsException e){
            System.out.println("Customer does not exist!");
            System.out.println();
        }
        System.out.println("\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Choose an option to continue *");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Add new product");
        System.out.println("2. Finish, save and return to main menu");
        System.out.println("0. Exit and leave");

        switch (readNumber()) {
            case 0:
                return;
            case 1:
                addProductToCustomer();
                break;
            case 2:
                finishAndSave();
                break;

                default:
                    System.out.println("Invalid option");
        }



    }


    private static int readNumber() {
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        boolean validinput = false;
        do {
            try {
                temp = sc.nextInt();
                validinput = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Enter a number please!");
            }
        } while (!validinput);
        return temp;
    }

    private void createNewCustomer() {

        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        name = firstLetterToUppercase(name);
        System.out.println("Please enter city: ");
        String city = input.nextLine();
        city = firstLetterToUppercase(city);
        System.out.println("\n");
        System.out.println("Welcome " + name + " from " + city + " your customer ID is: " + ++id);
        //System.out.println("Welcome " + name + " from " + city + " your customer ID is: " + atomicInteger.addAndGet(++id));
        System.out.println("\n");
        cr.addCustomer(new Customer(name, city, id));
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Please pick another option to continue *");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Add new product");
        System.out.println("2. See your shoppingcart");
        System.out.println("3. Finish and save");
        System.out.println("4. Create another customer");
        System.out.println("0. Exit and leave");

        switch (readNumber()) {
            case 0:
                return;
            case 1:
                addProductToCustomer();
                break;
            case 2:
                searchForCustomer();
                break;
            case 3:
                finishAndSave();
                break;
            case 4:
                createNewCustomer();
                break;
            default:
                System.out.println("Option not available!");

        }
        //System.out.println(atomicInteger.addAndGet(id));

        //int id = 0;

        //    customerRegister.customers.add(createNewCustomer(String name, String city);)
        //  customerRegister.customers.add(new Customer(String name, String city));
    }

    private void addProductToCustomer() {
        System.out.println("Enter customerID: ");
        int chosenId = input.nextInt();

        int id = chosenId;
        Customer customer = cr.getCustomer(id);

        if (customer != null) {

            for (int i = 0; i < sc.products.size(); i++)
                System.out.println(sc.products.get(i));

            System.out.println(pr.products);
            System.out.println("Choose product: ");
            int chosenProduct = input.nextInt();
            int productID = chosenProduct;
            Product product = pr.getProduct(productID);
            customer.customerList.add(product);
            System.out.println(customer);
            System.out.println(customer.customerList.toString());
        }
    }

//    private void seeShoppingCart() {
//        System.out.println("Enter customerID: ");
//        int chosenId = input.nextInt();
//
//        int id = chosenId;
//        Customer customer = cr.getCustomer(id);
//
//        if (customer != null) {
//
//            for (int i = 0; i < sc.products.size(); i++)
//                System.out.println(sc.products.get(i));
//
//        }
//    }
//    private int getInt() {
//        int nummer = 0;
//        try {
//
//            nummer = scanner.nextInt();
//            scanner.nextLine();
//
//        } catch (NumberFormatException e) {
//
//            System.out.println("Not found! Try again!");
//
//            return nummer;
//
//        }
//         return nummer;
//    }


    private void addNewProduct() {

        System.out.println("Enter a productname: ");
        String name = input.nextLine();
        System.out.println("Enter a category: ");
        String type = input.nextLine();
        System.out.println("Enter unit per piece/kg/l: ");
        String unit = input.nextLine();
        System.out.println("Enter price per unit: ");
        int price = input.nextInt();
       input.nextLine();
        System.out.println("\n");
        System.out.println("Product added as: " + "\n" + name + "\n" + type + "\n" + "Price per unit: " + price + "kr/" + unit + "piece/kg/l");
        System.out.println("\n");
        sc.addProduct(new Product(name, type, unit, price));
        pr.addNewProduct(new Product(name, type, unit, price));
        System.out.println("\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Do you wish to: *");
        System.out.println("^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Add another product");
        System.out.println("2. See your shoppingcart");
        System.out.println("3. Finish and save");
        System.out.println("0. Exit and leave");


        switch (readNumber()) {
            case 0:
                return;
            case 1:
                addNewProduct();
                break;
            case 2:
                searchForCustomer();
                break;
            case 3:
                finishAndSave();
                break;
            default:
                System.out.println("Option not available!");

        }

    }

    void finishAndSave()
        {
            //File file = new File("C:\\Users\\Martin\\Documents\\books.bin");
            String path = System.getProperty("user.home")
                    + File.separator + "Documents"
                    + File.separator + "regrister.bin";
            File file = new File(path);
            //Save object to file, run before closing the program
            try (ObjectOutputStream out =
                         new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
                out.writeObject(cr.customers);
                out.writeObject(pr.products);
                //out.writeObject(sc.customer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Save successfull");
            return;
        }


    void restoreSettings(){
        //File file = new File("C:\\Users\\Martin\\Documents\\books.bin");
        String path = System.getProperty("user.home")
                + File.separator + "Documents"
                + File.separator + "regrister.bin";
        File file = new File(path);

        //Load from file, run this code first in your program on start
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
//            ArrayList<Customer> c = (ArrayList<Customer>) in.readObject();
//            ArrayList<Product> p = (ArrayList<Product>) in.readObject();
            cr.customers = (ArrayList<Customer>) in.readObject();
            pr.products = (ArrayList<Product>) in.readObject();
            //sc.orderList = (ArrayList<String>) in.readObject();


        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String firstLetterToUppercase(String input) {

        String first = input.substring(0, 1).toUpperCase();
        String rest = input.substring(1).toLowerCase();

        return first + rest;
    }
}



