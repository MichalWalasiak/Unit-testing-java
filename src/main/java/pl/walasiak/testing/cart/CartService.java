package pl.walasiak.testing.cart;

public class CartService {

    private CartHandler cartHandler;

    public CartService(final CartHandler cartHandler) {
        this.cartHandler = cartHandler;
    }
}
