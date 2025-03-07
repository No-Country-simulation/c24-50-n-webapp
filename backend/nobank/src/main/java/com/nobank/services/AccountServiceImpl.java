package com.nobank.services;


import com.nobank.domain.model.Account;
import com.nobank.domain.model.User;
import com.nobank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private static final SecureRandom random = new SecureRandom(); // Generador más seguro

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

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElseThrow();
    }

    private String generarNumeroCuenta() {
        String prefix = "BANK"; // Prefijo personalizado
        String branchCode = "01"; // Código de sucursal (puede variar)
        String yearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMM")); // Año y mes actual
        String randomDigits = String.format("%06d", random.nextInt(1_000_000)); // 6 dígitos aleatorios

        return String.format("%s-%s-%s-%s", prefix, branchCode, yearMonth, randomDigits);
    }

    @Override
    public Account crearCuentaParaUsuario(User usuario) {
        Account account = new Account();
        account.setAccountNumber(generarNumeroCuenta());
        account.setUser(usuario);
        account.setBalance(0.0);
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());

        return accountRepository.save(account);
    }
}
