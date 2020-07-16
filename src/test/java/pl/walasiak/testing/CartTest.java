package pl.walasiak.testing;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;
    private Order order;

    @BeforeEach
    void initializeCartAndOrderObjects(){
        cart = new Cart();
        order = new Order();
    }

    @DisplayName("makes 1000 orders in less than 50 milliseconds")
    @Test
    void shouldBeDoneInLessThan50Milliseconds() {

        //when
        //then
        assertTimeout(Duration.ofMillis(50), cart::simulateLargeOrder);
    }

    @Disabled
    @DisplayName("makes 1000 orders in less than 20 millisecons")
    @Test
    void shouldBeDoneInLessThan20Milliseconds(){
        //when
        //then
        assertTimeout(Duration.ofMillis(20), ()-> cart.simulateLargeOrder());
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart(){
        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), allOf(
           notNullValue(),
           hasSize(1),
           is(not(empty())),
           is(not(emptyCollectionOf(Order.class)))
        ));

        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(0),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll(
                ()-> assertThat(cart.getOrders(), notNullValue()),
                ()-> assertThat(cart.getOrders(), hasSize(1)),
                ()-> assertThat(cart.getOrders(), is(not(empty()))),
                ()-> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                ()-> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, empty());
                }

        );
    }



    @AfterEach
    void tearDown(){
        cart.clearCart();
        order.cancel();
    }


}