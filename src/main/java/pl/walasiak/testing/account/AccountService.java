package pl.walasiak.testing.account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    AccountRepository accountRepository;

    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> getAllActiveAccounts() {
        return accountRepository.getAllAccounts().stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }

    List<Account> getAllNotActiveAccounts(List<Account> account) {
        return accountRepository.getAllAccounts()
                .stream()
                .filter(element -> !element.isActive())
                .collect(Collectors.toList());
    }
}
