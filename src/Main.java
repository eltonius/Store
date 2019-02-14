import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static javax.swing.UIManager.getInt;

public class Main {

    static Scanner input = new Scanner(System.in); //Scanner för att läsa in värde från användaren

//    private static Object getString;
//    private static CustomerRegister customerRegister;
//    private static ProductRegrister productRegrister;
//    static AtomicInteger atomicInteger = new AtomicInteger(0);//    private static Object CustomerRegister;
//    private Scanner scanner;
//    private int productID;
//    private Object String;
//    private Object ShoppingCart;
//    private Object ArrayList;

    private static Object Customer;
    static ShoppingCart sc = new ShoppingCart((Customer) Customer); //Arraylist
    static CustomerRegister cr = new CustomerRegister(); // Arraylist
    static ProductRegrister pr = new ProductRegrister(); // Arraylist
    static int id;

    //programmet startar här!
    public static void main(String[] args) throws IOException {

        Main mainObject = new Main(); //metod för att kunna kalla på objekt i main
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
            System.out.println("6. Add product to existing customer");
            System.out.println("7. Finish and save");
            System.out.println("0. Exit and leave");

            switch (readNumber()) {
                case 0:
                    System.out.println(" ________________________");
                    System.out.println("|                        |");
                    System.out.println("| Welcome back next time |");
                    System.out.println("|                        |");
                    System.out.println("|________________________|");
                    System.out.println("          | |");
                    System.out.println("          | |");
                    System.out.println("          |_|  ");


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
                    mainObject.addProductToCustomer();
                    break;
                case 7:
                    mainObject.finishAndSave();
                    break;
                default:
                    System.out.println("Option not available!");
            }
        }

    }

    //visar en lista på produkter
    private void productList() {
        System.out.println(pr.products);
    }

    //visar en lista på kunder
    private void customerList() {

        System.out.println(cr.customers);

    }

    //metod som gör det möjligt att söka efter kunder med deras ID
    private void searchForCustomer() {

        System.out.println("Enter customerID:");
        int chosenId = input.nextInt();
        int id = chosenId;
        Customer customer = cr.getCustomer(id);
        System.out.println(customer);
        System.out.println(customer.shoppingCartList);

        float totalPrice = 0;

        for (Product product : customer.shoppingCartList) {
            totalPrice += product.getPrice();
        }
        System.out.println("Total price: " + totalPrice + " " + "kr");

        try {
//            System.out.println(cr.getCustomer(id));
            //System.out.println(sc.getProducts());
            //    System.out.println("Total price: " + totalPrice + " " + "kr");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Customer does not exist!");
            System.out.println();
        }

        System.out.println("\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Choose an option to continue *");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Add new product to shoppingcart");
        System.out.println("2. Save and return to main menu");
        System.out.println("0. Go back to main menu");

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

    //läser in det nummer du väljer från switch-satserna
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
        sc.nextLine();
        return temp;
    }

    //skapar en ny kund
    private void createNewCustomer() {

        System.out.println("Please enter your name: ");
        String name = input.nextLine(); //värdet sparas i variabeln name
        name = firstLetterToUppercase(name); //ser till att första bokstaven blir stor
        System.out.println("Please enter your lastname: ");
        String lastname = input.nextLine();
        lastname = firstLetterToUppercase(lastname);
        System.out.println("Please enter city: ");
        String city = input.nextLine();
        city = firstLetterToUppercase(city);
        //input.nextLine();
        cr.addCustomer(new Customer(name, lastname, city, cr.customers.size() + 1)); //sparar i array
        System.out.println("Welcome " + name + " " + lastname + " from " + city + " your customer ID is: " + cr.customers.size());
        //System.out.println("Welcome " + name + " from " + city + " your customer ID is: " + atomicInteger.addAndGet(++id));
        System.out.println("\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Please pick another option to continue *");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(" -In order to add products, please save first!- ");
        System.out.println("1. Save");
        System.out.println("0. Go back to main menu");

        switch (readNumber()) {
            case 0:
                return;
            case 1:
                finishAndSave();
                break;
            default:
                System.out.println("Option not available!");
        }
        System.out.println("Thank you for saving! Please choose an option below ");
        System.out.println("1. Add product to your cart");
        System.out.println("2. See your shoppingcart");
        System.out.println("3. Create another customer");
        System.out.println("4. Return to main menu");
        switch (readNumber()) {
            case 1:
                addProductToCustomer();
                break;
            case 2:
                searchForCustomer();
                break;
            case 3:
                createNewCustomer();
                break;
            case 4:
                return;

            default:
                System.out.println("Something went wrong :(");
        }


        //System.out.println(atomicInteger.addAndGet(id));

        //int id = 0;

        //    customerRegister.customers.add(createNewCustomer(String name, String city);)
        //  customerRegister.customers.add(new Customer(String name, String city));
    }

    //lägger till produkt till kundID
    private void addProductToCustomer() {
        System.out.println("Enter customerID: ");
        int chosenId = input.nextInt();

        int id = chosenId;
        Customer customer = cr.getCustomer(id);

        if (customer != null) {

//            for (int i = 0; i < sc.products.size(); i++)
//                System.out.println(sc.products.get(i));

            System.out.println(pr.products);
            input.nextLine();
            System.out.println("Choose product by productID: ");
            int chosenProduct = input.nextInt();
            int productID = chosenProduct;
            Product product = pr.getProduct(productID);
            customer.shoppingCartList.add(product);
            System.out.println(customer);
            System.out.println(customer.shoppingCartList.toString());
            System.out.println("\n" + "*** Product added ***" + "\n");
            System.out.println("Do you wish to add another product?");
            System.out.println("1. Add another product");
            System.out.println("2. Save and go back to main menu");
            System.out.println("3. Go back to main menu");
            switch (readNumber()) {
                case 1:
                    addProductToCustomer();
                    break;
                case 2:
                    finishAndSave();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Oops! Something went wrong, try again!");
            }

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

    //lägger till ny produkt till produktlistan (sparas i en array)
    private void addNewProduct() {

        input.nextLine();
        System.out.println("Enter a productname: ");
        String name = input.nextLine();
        name = firstLetterToUppercase(name);
        input.nextLine();
        System.out.println("Enter a category: ");
        String type = input.nextLine();
        type = firstLetterToUppercase(type);
        System.out.println("Enter unit per piece/kg/l: ");
        String unit = input.nextLine();
        System.out.println("Enter price per unit: ");
        int price = input.nextInt();
        input.nextLine();
        System.out.println("\n");
        System.out.println("Product added as: " + "\n" + name + "\n" + type + "\n" + "Price per unit: " + price + "kr/" + " " + unit + " " + "piece/kg/l");
        System.out.println("\n");
        sc.addProduct(new Product(name, type, unit, price));
        pr.addNewProduct(new Product(name, type, unit, price));
        System.out.println("\n");
        System.out.println("^^^^^^^^^^^^^^^^^^^");
        System.out.println("* Do you wish to: *");
        System.out.println("^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Add another product to the store");
        System.out.println("2. Finish and save");
        System.out.println("0. Go back to main menu");


        switch (readNumber()) {
            case 0:
                return;
            case 1:
                addNewProduct();
                break;
            case 2:
                finishAndSave();
                break;
            default:
                System.out.println("Option not available!");

        }

    }

    //metod för att spara en bin-fil
    void finishAndSave() {
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
            //out.writeObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Save successful");
        return;
    }

    //återställer och hämtar från bin-fil
    void restoreSettings() {
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

    //omvandlar första bokstaven till stor
    public static String firstLetterToUppercase(String input) {

        String first = input.substring(0, 1).toUpperCase();
        String rest = input.substring(1).toLowerCase();

        return first + rest; //metoden returnerar variablerna first och rest
    }

    }
