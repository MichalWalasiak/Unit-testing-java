package pl.walasiak.testing.account;

import java.util.List;


import static org.mockito.Mockito.mock;

public class AccountServiceTest {

    // Given
    AccountRepository accountRepositoryStub = mock(AccountRepository.class);
    AccountService accountService = new AccountService(accountRepositoryStub);

    // When
    List<Account> list = accountService.getAllActiveAccounts();

    // Then
    assertThat()


}
