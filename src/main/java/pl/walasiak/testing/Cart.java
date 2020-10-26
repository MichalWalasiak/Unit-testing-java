package pl.walasiak.testing;

import pl.walasiak.testing.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    public void addOrderToCart(Order order){
        this.orders.add(order);
    }

    public void clearCart(){
        this.orders.clear();
    }

    public void simulateLargeOrder(){

        for(int i = 0; i < 1000; i++){
            Meal meal = new Meal(i%10, "Burger no " + i);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
        System.out.println("cart size " + orders.size());
        clearCart();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
