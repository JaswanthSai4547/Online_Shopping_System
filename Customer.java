package Online_shopping_System;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private long customer_id;
    private String name;
    private String email;
    private String address;
    private double bank_balance;
    private  Cart cart_object = new Cart();     //creating cart object //so this will create for every customer
    private static final Map<Long,Customer> customer_object = new HashMap<>();  //key is customer id and value is customer object


    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));  //buffered reader, to take inputs from user
    //constructor to assign values
    public Customer(long customer_id, String name, String email, String address, double bank_balance) {
        this.customer_id = customer_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.bank_balance = bank_balance;
    }
    //getter setter to access private variables in customer
    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBank_balance() {
        return bank_balance;
    }

    public void setBank_balance(double bank_balance) {
        this.bank_balance = bank_balance;
    }

    public Cart getCart_object() {
        return cart_object;
    }

    public void setCart_object(Cart cart_object) {
        this.cart_object = cart_object;
    }

    public static Map<Long, Customer> getCustomer_object() {
        return customer_object;
    }

    public static void setCustomer_object(Long customer_id, Customer customer_object) {
        Customer.customer_object.put(customer_id, customer_object);
    }

        // add to cart -- calls the add to cart method of the cart object of the customer
    public void add_to_cart(long product_id,long quantity){
        cart_object.add_to_cart(product_id, quantity);
    }
        //remove from cart - calls the remove from cart method of the cart object of the customer
    public void remove_from_cart(long product_id,long quantity)
    {
        cart_object.remove_from_cart(product_id, quantity);
    }
        // calculating the total cart value
    public void get_cart_total(){
        System.out.println("cart total : " + cart_object.get_cart_total());
    }
        //checkout method
    public void checkout(long customer_id){
        if(cart_object.get_cart_total() <= bank_balance)
        {
            //updating balance
            bank_balance-= cart_object.get_cart_total();
            //updating product quantity
            for(Map.Entry m : cart_object.getCart_items().entrySet()){
                long updated_quantity = (long) m.getValue();
                long update_productid = (long) m.getKey();
                ProductCatalog.getProduct_objects().get(update_productid).setQuantity_in_stock(ProductCatalog.getProduct_objects().get(update_productid).getQuantity_in_stock()-updated_quantity);
            }
            //flush the contents of the cart object
            for(Map.Entry m : cart_object.getCart_items().entrySet()) {
                System.out.println("Product Id = "+m.getKey());
                System.out.println("  Quantity =" + customer_object.get(customer_id).getCart_object().getCart_items().get(m.getKey()));
            }
            //print the balance and success message
            System.out.println("balance = "+bank_balance+"/-");
            System.out.println("successfully checkout");
            cart_object.clear_cart();
        }
        else{
            System.out.println("Balance is not Sufficient");
        }
    }
}
