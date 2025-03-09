package com.nobank.controllers;

import com.nobank.entities.Account;
import com.nobank.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen - Aqui va la URL de React o Frontend
@RequestMapping("/api/accounts")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Lista todas las cuentas")
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.listarAccounts();
        return ResponseEntity.ok(accounts);
    }

    @Operation(summary = "Obtiene una cuenta por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id) {
        Account account = accountService.listarPorId(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/create")
    @Operation(summary = "Crear una nueva cuenta")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        accountService.guardar(account);
        return ResponseEntity.ok(account);
    }

    // BALANCE
    @GetMapping("/balance/{accountNumber}")
    public ResponseEntity<Map<String, Double>> getBalance(@PathVariable String accountNumber) {
        var response = new HashMap<String, Double>();
        Account account = accountService.findByAccountNumber(accountNumber);
        response.put("balance", account.getBalance());
        return ResponseEntity.ok(response);
    }

    // MOVIMIENTOS
    @GetMapping("/movements/{accountNumber}")
    public ResponseEntity<Map<String, Object>> getMovements(@PathVariable String accountNumber) {
        var response = new HashMap<String, Object>();
        Account account = accountService.findByAccountNumber(accountNumber);
        response.put("movimientos", account.getTransactions());
        return ResponseEntity.ok(response);
    }
}
