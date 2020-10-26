package pl.walasiak.testing.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {

    @Override
    public List<Account> getAllAccounts() {
        Adress adress1 = new Adress("Piekarnicza", "3");
        Adress adress2 = new Adress("Lema", "15");

        Account account = new Account(adress1);
        Account account1 = new Account(adress2);
        Account account2 = new Account();

        return Arrays.asList(account, account1, account2);
    }
}
