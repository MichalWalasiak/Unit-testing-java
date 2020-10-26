package pl.walasiak.testing.account;

public class AccountService {

    AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
