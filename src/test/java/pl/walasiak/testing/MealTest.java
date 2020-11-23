package pl.walasiak.testing;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.walasiak.testing.extensions.IAExceptionIgnoreExtension;
import pl.walasiak.testing.order.Order;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MealTest {

    @Test
    void shouldReturnCorrectDiscountedPrice() {

        //given
        Meal meal = new Meal(35);
        //when
        int discountedPrice = meal.getDiscountedRate(7);
        //then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice).isEqualTo(28);


    }

    @Test
    void refferencesToTheSameObjectsShouldBeEqual() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        assertSame(meal1, meal2);
        assertThat(meal1).isSameAs(meal2);

    }

    @Test
    void refferencesToTheDifferentObjectsShouldNotBeEqual() {
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        //then
        assertNotEquals(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);

    }

    @Test
    void twoMealsShouldBeEqualWhenNameAndPriceAreTheSame() {
        //given
        Meal meal1 = new Meal(40, "burger");
        Meal meal2 = new Meal(40, "burger");
        //then
        assertEquals(meal1, meal2);
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanPrice() {
        //given
        Meal meal = new Meal(10, "Pizza");

        //when + then

        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedRate(12));

    }


    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 18})
    void melaPriceShouldBeLowerThan20(int price) {
        assertThat(price).isLessThan(20);
        assertThat(price, lessThan(20));
    }

    @ParameterizedTest
    @MethodSource("createMealswithNameAndPrice")
    void burgersShuldHavecorrectNameAndPrice(String name, int price){
        assertThat(name, containsString("burger"));
        assertThat(price, greaterThanOrEqualTo(10));
    }


    private static Stream<Arguments> createMealswithNameAndPrice(){
           return Stream.of(
                Arguments.of("Hamburger", 10),
                Arguments.of("Cheseburger", 12)

        );

    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakesShouldHaveCorrectNames(String name){
        assertThat(name, containsString("cake"));
    }

    private static Stream<String> createCakeNames(){
        List<String> cakeNames = Arrays.asList("chesecake", "fruitcake", "cupcake");

        return cakeNames.stream();
    }


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    @ExtendWith(IAExceptionIgnoreExtension.class)
    void melaPriceShouldBeLowerThan10(int price) {

        if (price > 5){
            throw new IllegalArgumentException();
        }

        assertThat(price).isLessThan(10);
        assertThat(price, lessThan(10));
    }

    @Tag("Fries")
    @TestFactory
    Collection<DynamicTest> calculateMealPrice(){
        Order order = new Order();
        order.addMealToOrder(new Meal(12, 2, "Burger"));
        order.addMealToOrder(new Meal(7, 4, "Fries"));
        order.addMealToOrder(new Meal(20, 3, "Pizza"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < order.getMeals().size(); i++){
            int price = order.getMeals().get(i).getPrice();
            int quantiti = order.getMeals().get(i).getQuantity();

            Executable executable = ()-> {
                assertThat(calculateTotalPrice(price, quantiti), lessThan(61));
            };

            String name = "test name " + i;
            DynamicTest dynamicTest = DynamicTest.dynamicTest(name, executable);
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests;
    }

    @Test
    void testSumPrice() {
        //given
        Meal meal = mock(Meal.class);
        given(meal.getPrice()).willReturn(15);
        given(meal.getQuantity()).willReturn(3);

        //when
        //then
    }

    private int calculateTotalPrice(int price, int quantity){
        return price * quantity;
    }


}







