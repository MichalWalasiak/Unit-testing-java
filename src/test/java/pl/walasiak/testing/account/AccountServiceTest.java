package pl.walasiak.testing.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
    void shouldreturnAllActiveAccounts(){

        // Given
        List<Account> testList = prepeareList();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountService.getAllActiveAccounts()).thenReturn(testList);

        // When
        List<Account> list = accountService.getAllActiveAccounts();

        // Then
        assertThat(list, hasSize(2));
    }

    @Test
    void shouldreturnAllNotActiveAccounts(){

        // Given
        List<Account> testList = prepeareList();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountService.getAllActiveAccounts()).thenReturn(testList);

        // When
        List<Account> list = accountService.getAllNotActiveAccounts(testList);

        // Then
        assertThat(list, hasSize(1));
    }

    private List<Account> prepeareList() {
        Adress adress1 = new Adress("Piekarnicza", "3");
        Adress adress2 = new Adress("Lema", "15");

        Account account = new Account(adress1);
        Account account1 = new Account(adress2);
        Account account2 = new Account();

        return Arrays.asList(account, account1, account2);
    }
}
