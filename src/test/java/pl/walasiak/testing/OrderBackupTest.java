package pl.walasiak.testing;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;
    private Order order;

    @BeforeAll
    static void createFile() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void initializeOrder(){
        order = new Order();
    }

    @Tag("Fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7, "Fries");
        order.addMealToOrder(meal);
        //when
        orderBackup.backUpOrder(order);
        //then
        System.out.println("order " + order.toString() + " backed up");

    }

    @AfterEach
    void clean(){
        order.cancel();
    }



    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
