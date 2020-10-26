package pl.walasiak.testing.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdressTest {

    @ParameterizedTest
    @CsvSource({"Puławska, 45", "Armii Krajowej, 57/10", "'Tytusa, Romka, Atomka', 7/4"})
    void givenAdressShouldHaveNumbersAndHaveProperNumber(String name, String number){
        assertThat(name, notNullValue());
        assertThat(name, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/adresses.csv")
    void adressesFromFileSourceShouldHaveNameAndHaveProperNumber(String name, String number){
        assertThat(name, notNullValue());
        assertThat(name, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }
}
