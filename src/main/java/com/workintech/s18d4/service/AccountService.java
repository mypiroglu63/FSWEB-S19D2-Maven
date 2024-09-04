package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();
    Account findAccountById(Long id);
    Account saveAccount(Account account, Long customerId);
    Account updateAccount(Long id, Account accountDetails);
    void deleteAccount(Long id);
}
