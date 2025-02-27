package com.nobank.services;

import java.util.List;

import com.nobank.domain.model.Account;

public interface AccountService {
    List<Account> listarAccounts();
    Account listarPorId(Long id);
    void guardar(Account account);
    void eliminar(Long id);
}
