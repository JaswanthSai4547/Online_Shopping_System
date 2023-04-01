package Online_shopping_System;

import java.util.HashMap;
import java.util.Map;

public class Cart{       //creating class for cart

    // creating hashmap to store key as product_id and value as Quantity.
    private final Map<Long,Long> cart_items = new HashMap<>();



    //constructor to initialize an empty dictionary
    public Cart() {
    }

    //getter setter to access cart items hashmap
    public Map<Long, Long> getCart_items() {
        return cart_items;
    }

    public void setCart_items(long product_id,long quantity) {
        this.cart_items.put(product_id,quantity);
    }


    //creating methods to do basic operations on cart
    //method1 = add the products to cart (takes the product_id and quantity as arguments)
    public void add_to_cart(long product_id,long quantity)
    {
        //checking if the entered quantity is less than or equal to the stock of the product
        if(ProductCatalog.getProduct_objects().get(product_id).getQuantity_in_stock()>=quantity) {
            // if the product_id is already in the dictionary,
            // increase the quantity by the given quantity.
            if (cart_items.containsKey(product_id)) {
                cart_items.put(product_id, cart_items.get(product_id) + quantity);
                System.out.println("product is already in cart \n product_id :-" + product_id + " quantity :-" + cart_items.get(product_id));
            }
            //if the product_id is not in the dictionary,create an entry in
            //the dictionary with the key as product_id and value as Quantity.
            else {
                cart_items.put(product_id, quantity);
                System.out.println("product added to cart \n product_id :-" + product_id + "quantity :-" + cart_items.get(product_id));
            }
        }else {
            System.out.println("available quantity is less than your requirement\ntry again");
        }

    }


    //method2 - removing the products from the cart (takes the product_id and quantity as arguments)
    public void remove_from_cart(long product_id,long quantity){
            //if the product_id is not in the cart, print an error message
        if(!cart_items.containsKey(product_id)){
            System.out.println("Product is not in the Cart");
            return;
        }
            //if the product_id is present in the cart and the quantity is greater than
            //or equal to the quantity in the cart, remove that much quantity from the dictionary
        if(cart_items.containsKey(product_id)){
            if(quantity >= cart_items.get(product_id)){
                cart_items.remove(product_id);
                System.out.println("product removed from the cart");
                return;
            }
        }
            //if the product_id is present in the cart and the quantity is less tan
            //to the quantity in the cart, decrease the quantity in the cart by the given quantity
        if(cart_items.containsKey(product_id)){
            if(quantity < cart_items.get(product_id)){
                cart_items.put(product_id,cart_items.get(product_id)-quantity);
                System.out.println("product quantity is decreased\nproduct_id:-"+product_id+"quantity:-"+cart_items.get(product_id));

            }
        }
    }

    //method-3 = get cart total //it will return the total price of all items in the cart
    public double get_cart_total(){
        double cart_total=0;
        for(Map.Entry m : cart_items.entrySet()){
            cart_total+= ProductCatalog.getProduct_objects().get(m.getKey()).getPrice() * cart_items.get(m.getKey());
        }
        return cart_total;
    }

    //method -4 = used to clear the cart of corresponding customer
    public void clear_cart(){
        cart_items.clear();
        System.out.println("Cart Cleared");
    }
}
