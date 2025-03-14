package com.nobank.service;

import com.nobank.domain.cuenta.Cuenta;
import com.nobank.domain.perfil.Perfil;
import com.nobank.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;


    public void guardarCuenta(Cuenta cuenta){
        cuentaRepository.save(cuenta);
    }

    public Cuenta buscarCuentaPorNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public Perfil buscarPerfilPorNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta).orElseThrow(() -> new RuntimeException("Cuenta no encontrada")).getUsuario().getPerfil();
    }

}
