package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountBase {
    Map<User, List<Account>> base;

    AccountBase() {
        base = new HashMap<>();
    }

    public void addUser(User user) {
        base.putIfAbsent(user, new ArrayList<Account>());

    }

    public void deleteUser(User user) {
        base.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User key : base.keySet()) {
            if (key.getPassport().equals(passport)) {
                base.get(key).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User key : base.keySet()) {
            if (key.getPassport().equals(passport)) {
                int index = base.get(key).indexOf(account);
                base.get(key).remove(index);
            }
        }

    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User key : base.keySet()) {
            if (key.getPassport().equals(passport)) {
                System.out.println(base.get(key));
            }
        }

        return result;
    }
}

