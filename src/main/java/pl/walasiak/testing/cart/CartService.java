package pl.walasiak.testing.cart;

import pl.walasiak.testing.order.OrderStatus;

public class CartService {

    private CartHandler cartHandler;

    public CartService(final CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }

    Cart processCart(Cart cart) {
        if (cartHandler.canHandleCart(cart)){
            cartHandler.sendToPrepeare(cart);
            cart.getOrders().forEach(order -> {
                order.changeOrderStatus(OrderStatus.PREPARED);
            });
            return cart;
        }else{
            cart.getOrders().forEach(order -> {
                order.changeOrderStatus(OrderStatus.REJECTED);
            });
            return cart;
        }
    }
}
