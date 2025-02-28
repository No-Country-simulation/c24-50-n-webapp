package com.nobank.services;

import com.nobank.domain.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> listarAccounts();

    Account listarPorId(Long id);

    void guardar(Account account);

    void eliminar(Long id);

    Account findByAccountNumber(String accountNumber);
}
