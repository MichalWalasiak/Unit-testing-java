package pl.walasiak.testing.cart;

public interface CartHandler {

    boolean canHandleCart(Cart cart);

    void sendToPrepeare(Cart cart);
}