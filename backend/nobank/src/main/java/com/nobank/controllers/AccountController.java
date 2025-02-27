package com.nobank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobank.domain.model.Account;
import com.nobank.services.AccountService;

import io.swagger.v3.oas.annotations.Operation;

//@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen - Aqui va la URL de React o Frontend
@RequestMapping("/api/accounts")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Operation(summary = "Lista todas las cuentas")
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.listarAccounts();
        return ResponseEntity.ok(accounts);
    }

    @Operation(summary = "Obtiene una cuenta por su id")
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id){
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
}
