package pl.walasiak.testing.cart;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.walasiak.testing.order.Order;
import pl.walasiak.testing.order.OrderStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CartServiceTest {

    @Test
    void processCartShouldSendOrderToPrepeare() {

        //given
        Order order = new Order();
        Cart cart = new Cart();
        cart.addOrderToCart(order);

        CartHandler cartHandler = mock(CartHandler.class);
        CartService cartService = new CartService(cartHandler);
        given(cartHandler.canHandleCart(cart)).willReturn(true);

        //when
        Cart resultCart = cartService.processCart(cart);

        //then
        verify(cartHandler).sendToPrepeare(cart);
        assertThat(resultCart.getOrders(), hasSize(1));
        assertThat(resultCart.getOrders().get(0).getOrderStatus(), equalTo(OrderStatus.PREPARED));
    }
}
