package Online_shopping_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        ProductCatalog productCatalog_object = new ProductCatalog();
        int choice=12;
        while (true){
            System.out.println("*****************************************");
            System.out.println("|    0.create Customer                  |");
            System.out.println("|    1.print the product catalog        |");
            System.out.println("|    2.add a product                    |");
            System.out.println("|    3.load stock of a product          |");
            System.out.println("|    4.add product to the cart          |");
            System.out.println("|    5.print Cart                       |");
            System.out.println("|    6.checkout cart                    |");
            System.out.println("|    7.display the total price of cart  |");
            System.out.println("|    8.print bank balance               |");
            System.out.println("|    9.print details of product         |");
            System.out.println("|    10.exit                            |");
            System.out.println("|    11.remove product to the cart      |");
            System.out.println("*****************************************");
            try {
                choice = Integer.parseInt(br2.readLine());
            }catch (Exception ignored) {}
            switch (choice){
                case 0:
                    try {
                        System.out.println("customer id:");
                        long customer_id = Long.parseLong(br2.readLine());
                        System.out.println("Name:");
                        String name = br2.readLine();
                        System.out.println("Email:");
                        String email = br2.readLine();
                        while (!email.matches("^(.+)@(.+)$")) {
                            System.out.println("enter correct credentials again");
                            email = br2.readLine();
                        }
                        System.out.println("Address:");
                        String address = br2.readLine();
                        System.out.println("Bank Balance:");
                        double balance = Double.parseDouble(br2.readLine());
                        Customer object = new Customer(customer_id, name, email, address, balance);
                        Customer.setCustomer_object(customer_id, object);
                        System.out.println("customer created successfully");
                        }catch (IOException e){
                            System.out.println("Invalid input");
                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                        break;
                case 1:
                    productCatalog_object.print_catalogue();
                    break;
                case 2:
                    try {
                        System.out.println("product name:");
                        String product_name = br2.readLine();
                        System.out.println("product description:");
                        String description = br2.readLine();
                        System.out.println("price:");
                        double price = Double.parseDouble(br2.readLine());
                        System.out.println("quantity");
                        long quantity = Long.parseLong(br2.readLine());
                        productCatalog_object.add_product(product_name, description, price, quantity);
                        System.out.println("Product Added Successfully");
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("enter product id:");
                        long product_id = Long.parseLong(br2.readLine());
                        System.out.println("enter quantity:");
                        long load_quantity = Long.parseLong(br2.readLine());
                        productCatalog_object.load_stock(product_id, load_quantity);
                    }catch (IOException io){
                        System.out.println("Invalid input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.println("enter customer id:");
                        long customer_id1 = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id1)) {
                            System.out.println("product id:");
                            long product_id_in_add = Long.parseLong(br2.readLine());
                            if (ProductCatalog.getProduct_objects().containsKey(product_id_in_add)) {
                                System.out.println("Quantity:");
                                long quantity_in_add = Long.parseLong(br2.readLine());
                                Customer.getCustomer_object().get(customer_id1).add_to_cart(product_id_in_add, quantity_in_add);
                            } else {
                                System.out.println("product id not found");
                            }
                        } else {
                            System.out.println("customer id not found");
                        }
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    try {
                        System.out.println("enter customer id:");
                        long customer_id_print = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id_print)) {
                            for (Map.Entry m : Customer.getCustomer_object().get(customer_id_print).getCart_object().getCart_items().entrySet()) {
                                System.out.println("--------------------");
                                System.out.println("Product Id = " + m.getKey());
                                System.out.println("Quantity = " + Customer.getCustomer_object().get(customer_id_print).getCart_object().getCart_items().get(m.getKey()));
                                System.out.println("--------------------");
                            }
                        } else {
                            System.out.println("customer not exist");
                        }
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6:
                    try {
                        System.out.println("enter Customer id:");
                        long customer_id_checkout = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id_checkout)) {
                            Customer.getCustomer_object().get(customer_id_checkout).checkout(customer_id_checkout);
                        } else {
                            System.out.println("customer not exist");
                        }
                    }catch (IOException io){
                        System.out.println("invalid input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 7:
                    try {
                        System.out.println("enter Customer id:");
                        long customer_id_cart_t = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id_cart_t)) {
                            Customer.getCustomer_object().get(customer_id_cart_t).get_cart_total();
                        } else {
                            System.out.println("customer not exist");
                        }
                    }catch (IOException e){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                    try {
                        System.out.println("enter Customer id:");
                        long customer_id_balance = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id_balance)) {
                            System.out.println("Bank Balance = " + Customer.getCustomer_object().get(customer_id_balance).getBank_balance() + "/-");
                        } else {
                            System.out.println("customer not exist");
                        }
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 9:
                    try {
                        System.out.println("enter product id : ");
                        long product_id_print = Long.parseLong(br2.readLine());
                        if (ProductCatalog.getProduct_objects().containsKey(product_id_print)) {
                            System.out.println("--------------------------");
                            System.out.println("ID : " + ProductCatalog.getProduct_objects().get(product_id_print).getProduct_id());
                            System.out.println("NAME : " + ProductCatalog.getProduct_objects().get(product_id_print).getProduct_name());
                            System.out.println("DESCRIPTION : " + ProductCatalog.getProduct_objects().get(product_id_print).getProduct_description());
                            System.out.println("PRICE : " + ProductCatalog.getProduct_objects().get(product_id_print).getPrice());
                            System.out.println("QUANTITY : " + ProductCatalog.getProduct_objects().get(product_id_print).getQuantity_in_stock());
                            System.out.println("--------------------------");
                        } else {
                            System.out.println("product id not found");
                        }
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 10:
                    System.exit(0);
                case 11:
                    try {
                        System.out.println("enter customer id:");
                        long customer_id_remove = Long.parseLong(br2.readLine());
                        if (Customer.getCustomer_object().containsKey(customer_id_remove)) {
                            System.out.println("product id:");
                            long product_id_in_remove = Long.parseLong(br2.readLine());
                            if (ProductCatalog.getProduct_objects().containsKey(product_id_in_remove)) {
                                System.out.println("Quantity:");
                                long quantity_in_add = Long.parseLong(br2.readLine());
                                Customer.getCustomer_object().get(customer_id_remove).remove_from_cart(product_id_in_remove, quantity_in_add);
                            } else {
                                System.out.println("product id not found");
                            }
                        } else {
                            System.out.println("customer id not found");
                        }
                    }catch (IOException io){
                        System.out.println("Invalid Input");
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                default:
                    System.out.println("Invalid Input---");
            }
        }
    }
}