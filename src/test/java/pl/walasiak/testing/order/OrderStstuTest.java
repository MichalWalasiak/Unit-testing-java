package pl.walasiak.testing.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.walasiak.testing.order.OrderStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


class OrderStstuTest {

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldBeLessThan15Characters(OrderStatus orderStatus){
        assertThat(orderStatus.toString().length(), lessThan(15));
    }
}
