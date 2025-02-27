package com.nobank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nobank.domain.model.Account;
import com.nobank.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> listarAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account listarPorId(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void eliminar(Long id) {
        accountRepository.deleteById(id);
    }
}
