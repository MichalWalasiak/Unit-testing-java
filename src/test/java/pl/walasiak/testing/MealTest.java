package pl.walasiak.testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void refferencesToTheSameObjectsShouldBeEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;
        //then
        assertSame(meal1, meal2);
        assertThat(meal1).isSameAs(meal2);

    }

    @Test
    void refferencesToTheDifferentObjectsShouldNotBeEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(20);
        //then
        assertNotEquals(meal1, meal2);
        assertThat(meal1).isNotSameAs(meal2);

    }

    @Test
    void twoMealsShouldBeEqualWhenNameAndPriceAreTheSame(){
        //given
        Meal meal1 = new Meal(40, "burger");
        Meal meal2 = new Meal(40, "burger");
        //then
        assertEquals(meal1, meal2);
    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanPrice(){
        //given
        Meal meal = new Meal(10, "Pizza");

        //when + then

        assertThrows(IllegalArgumentException.class, ()-> meal.getDiscountedRate(12));

    }


}