package pl.walasiak.testing.account;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;


class AccountServiceStubTest {

    @Test
    void getAllActiveAccounts() {
        // Given
        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepositoryStub);

        // When
        List<Account> list = accountService.getAllActiveAccounts();

        // Then
        assertThat(list, hasSize(2));
    }
}