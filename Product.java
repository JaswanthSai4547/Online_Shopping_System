package Online_shopping_System;


public class Product {            //creating class for products

    //creating required variables to store products details
    private long product_id;
    private String product_name;
    private String product_description;
    private double price;
    private long quantity_in_stock;

    //creating constructor for assigning values for the variables

    public Product(long product_id, String product_name, String product_description, double price, long quantity_in_stock) {
        this.product_id = product_id;
        this.product_name = product_name;                        //this keyword refers to the current class object
        this.product_description = product_description;
        this.price = price;
        this.quantity_in_stock = quantity_in_stock;
    }

    //to access private variables we need getter and setter
    //creating getter setters for the required private varibales


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(long quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }


    //method to generate total price of the product you are buying
    public double get_total_price(long quantity){
        if(quantity>quantity_in_stock)
            return quantity*price;
        else
            return -1;
    }
}
