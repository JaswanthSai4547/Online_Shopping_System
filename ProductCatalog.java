package Online_shopping_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    //map to store the objects of products
    //key is product id and value is product object
    private static Map<Long,Product> product_objects = new HashMap<>();
    static long id =1000;
    BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));  //to enter data from user

    //default constructor - we are creating the instance of product catalog in Main class
    public ProductCatalog() {
    }

    //getter setters to access private variables
    public static Map<Long, Product> getProduct_objects() {
        return product_objects;
    }

    public static void setProduct_objects(Map<Long, Product> product_objects) {
        ProductCatalog.product_objects = product_objects;
    }

    //creates a product objects and create an entry in the map
    public void add_product(String product_name, String description, double price, long quantity){
            id+=1;
            Product object = new Product(id,product_name,description,price,quantity);
            product_objects.put(id,object);
    }
    //To load stock-If the id is present,the quantity of the corresponding product object is incremented, if not prints error message
    public void load_stock(long product_id,long load_quantity){
        if(product_objects.containsKey(product_id)){
            product_objects.get(product_id).setQuantity_in_stock(load_quantity+product_objects.get(product_id).getQuantity_in_stock());
            System.out.println("successfully updated");
        }
        else {
            System.out.println("product is not present");
        }
    }
    //returns the product object of the given product id
    public Product search_product(long product_id)
    {
            return product_objects.get(product_id);
    }
    //print the products available in the catalog
    public void print_catalogue(){
        if(product_objects.size()>0) {
            for (Map.Entry m : product_objects.entrySet()) {
                System.out.println("--------------------------");
                System.out.println("ID : " + product_objects.get(m.getKey()).getProduct_id());
                System.out.println("NAME : " + product_objects.get(m.getKey()).getProduct_name());
                System.out.println("DESCRIPTION : " + product_objects.get(m.getKey()).getProduct_description());
                System.out.println("PRICE : " + product_objects.get(m.getKey()).getPrice());
                System.out.println("QUANTITY : " + product_objects.get(m.getKey()).getQuantity_in_stock());
                System.out.println("--------------------------");
            }
        }else {
            System.out.println("No Products in Product Catalog");
        }
    }
}
