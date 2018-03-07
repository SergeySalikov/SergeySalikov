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
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User key : base.keySet()) {
            if (key.getPassport().equals(passport)) {
                int index = base.get(key).indexOf(account);
                base.get(key).remove(index);
                break;
            }
        }

    }

    public List<Account> getUserAccounts(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        for (User key : base.keySet()) {
            if (key.getPassport().equals(passport)) {
                result.addAll(base.get(key));
                break;
            }
        }

        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        double valueDst = -amount;
        double valueSrc = this.getValue(srcPassport, srcRequisite);
        if (valueSrc >= amount) {
            result = this.addValue(dstPassport, dstRequisite, amount);
            this.addValue(srcPassport, srcRequisite, valueDst);
        }
        return result;
    }
    private double getValue(String srcPassport, String srcRequisite) {
        double result = -1;
        List<Account> userAccount = this.getUserAccounts(srcPassport);
        for (Account account : userAccount) {
            if (account.getRequisites() == Integer.parseInt(srcRequisite)) {
                result = account.getValue();
                break;
            }
        }
        return result;
    }

    private boolean addValue(String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        List<Account> userAccount = this.getUserAccounts(dstPassport);
        for (Account account : userAccount) {
            if (account.getRequisites() == Integer.parseInt(dstRequisite)) {
                account.setValue(amount);
                result = true;
                break;
            }
        }

        return result;
    }
}
