package com.nobank.services;

import com.nobank.entities.Account;
import com.nobank.entities.User;

import java.util.List;

public interface AccountService {
    List<Account> listarAccounts();

    Account listarPorId(Long id);

    void guardar(Account account);

    void eliminar(Long id);

    Account findByAccountNumber(String accountNumber);
    
    Account crearCuentaParaUsuario(User usuario);
}
