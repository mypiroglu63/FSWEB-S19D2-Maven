package com.workintech.s18d4.service;

import com.workintech.s18d4.dao.AccountRepository;
import com.workintech.s18d4.dao.CustomerRepository;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account saveAccount(Account account, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        account.setCustomer(customer);
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account accountDetails) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        existingAccount.setAccountName(accountDetails.getAccountName());
        existingAccount.setMoneyAmount(accountDetails.getMoneyAmount());

        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
