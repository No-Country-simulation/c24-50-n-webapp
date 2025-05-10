package com.nobank.service;

import com.nobank.domain.perfil.Perfil;
import com.nobank.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public void guardarPerfil(Perfil perfil){
        perfilRepository.save(perfil);
    }
}
