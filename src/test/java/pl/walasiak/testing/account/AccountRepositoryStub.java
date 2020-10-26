package pl.walasiak.testing.account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository {

    @Override
    public List<Account> getAllAccounts() {
        Adress adress1 = new Adress("Piekarnicza", "3");
        Adress adress2 = new Adress("Lema", "15");

        Account account = new Account(adress1);
        Account account1 = new Account(adress2);
        Account account2 = new Account();

        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        accountList.add(account1);
        accountList.add(account2);

        return accountList;
    }
}
