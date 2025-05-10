package com.nobank.controller;


import com.nobank.domain.rolTipo.RolTipo;
import com.nobank.repository.RolTipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rol-tipo")
public class RolTipoController {


    @Autowired
    private RolTipoRepository rolTipoRepository;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody RolTipo rolTipo){
        return ResponseEntity.ok(rolTipoRepository.save(rolTipo));
    }
}
