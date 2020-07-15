package pl.walasiak.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        System.out.println("before every test method");
        order = new Order();
    }

    @AfterEach
    void cleanUp(){

        System.out.println("after each test merhod");
        order.cancel();
    }

    @Test
    void testAssertArraysEquals(){

        //given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};
        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void test_MealList_ShouldBeEmptyAfterCreation(){

        //when
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
        assertThat(order.getMeals(), hasSize(0));
    }

    @Test
    void test_addingOneMealToOrderList_ReturnListSizeEqualToOne(){
        //given
        Meal meal = new Meal(35, "burger");
        Meal meal2 = new Meal(5, "sandwich");

        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals().size(), equalTo(1));
        assertThat(order.getMeals().get(0).getPrice(), equalTo(35));

    }

    @Test
    void test_removingOneMealFromOrderList_ReturnListSizeEqualToZero(){
        //given
        Meal meal = new Meal(35, "burger");
        Meal meal1 = new Meal(15, "sandwich");
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);

        //when
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals().size(), equalTo(1));
        assertThat(order.getMeals().get(0).getName(), equalTo("sandwich"));
        assertThat(order.getMeals(), contains(meal1));
    }

    @Test
    void test_correctOrder_MealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        //given
        Meal meal = new Meal(35, "burger");
        Meal meal1 = new Meal(15, "sandwich");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);

        //then
        assertThat(order.getMeals().size(), equalTo(2));
        assertThat(order.getMeals(), containsInAnyOrder(meal1, meal));

    }

    @Test
    void test_twoListOrders_twoListOrdersSouldBeEqual(){
        //given
        Meal meal = new Meal(35, "burger");
        Meal meal1 = new Meal(15, "sandwich");
        Meal meal2 = new Meal(11, "kebab");

        List<Meal> meals1 = Arrays.asList(meal, meal1);
        List<Meal> meals2 = Arrays.asList(meal, meal1);

        //then
        assertThat(meals1, is(meals2));

    }
}
