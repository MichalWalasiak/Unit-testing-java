package pl.walasiak.testing.account;

import org.junit.jupiter.api.Test;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;

public class AccountServiceTest {

    @Test
    void shouldreturnAllActiveAccounts(){

        // Given
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);

        // When
        List<Account> list = accountService.getAllActiveAccounts();

        // Then
        assertThat(list, hasSize(2));

    }


}
