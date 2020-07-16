package pl.walasiak.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given
        Account account = new Account();
        //then
        assertFalse(account.isActive(), "check if account is active");
        assertThat(account.isActive()).isFalse();

    }

    @Test
    void newAccountShouldBeActiveAfterActivation(){
        //given
        Account account = new Account();
        //when
        account.activate();
        //then
        assertTrue(account.isActive());
        assertThat(account.isActive()).isTrue();

    }

    @Test
    void newCreatedAccountShouldNotHaveDefoultDeliveryAdress(){
        //given
        Account account = new Account();
        //when
        Adress adress = account.getDefoultDeliveryAdress();
        //then
        assertNull(adress);
        assertThat(adress).isNull();

    }

    @Test
    void defoultDeliveryAdressShouldNotBeNullAfterBeingSet(){
        //given
        Account account = new Account();
        Adress adress = new Adress("szkolna", "5");
        account.setDefoultDeliveryAdress(adress);
        //when
        Adress defaoultAdress = account.getDefoultDeliveryAdress();
        //then
        assertNotNull(defaoultAdress);
        assertThat(defaoultAdress).isNotNull();

    }

    @RepeatedTest(5)
    void accountWithNotNullDefaultAdressShouldBeActive(){
        //given
        Adress adress = new Adress("Puławska", "46");

        //when
        Account account = new Account(adress);

        //then
        assumingThat(adress == null, ()->{
            assertTrue(account.isActive());

        });
    }
}
