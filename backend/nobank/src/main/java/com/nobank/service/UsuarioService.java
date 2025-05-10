package com.nobank.service;

import com.nobank.domain.cuenta.Cuenta;
import com.nobank.domain.perfil.Perfil;
import com.nobank.domain.rolTipo.RolTipo;
import com.nobank.domain.usuario.DatosRegistroUsuario;
import com.nobank.domain.usuario.Usuario;
import com.nobank.domain.usuario.UsuarioDTO;
import com.nobank.infra.security.SecurityService;
import com.nobank.repository.RolTipoRepository;
import com.nobank.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolTipoRepository rolTipoRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registrarUsuarioCliente(DatosRegistroUsuario datosRegistroUsuario, HttpServletRequest request) {

        String ipActual = this.obtenerIpCliente(request);

        RolTipo rolTipo = rolTipoRepository.findByNombre("CLIENTE")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        String passwordHash = passwordEncoder.encode(datosRegistroUsuario.contraseña());

        Usuario usuario = new Usuario(datosRegistroUsuario.dni(), passwordHash, rolTipo, ipActual);
        usuario = usuarioRepository.save(usuario);

        Perfil perfil = new Perfil(null, datosRegistroUsuario.nombre(), datosRegistroUsuario.correo(), usuario);

        Cuenta cuenta = new Cuenta(usuario, generarNumeroCuenta());

        cuentaService.guardarCuenta(cuenta);
        perfilService.guardarPerfil(perfil);

        return usuario;
    }

    public Usuario buscarUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario buscarUsuarioPorDni(String dni){
        return (Usuario) usuarioRepository.findByDni(dni);
    }

    private String generarNumeroCuenta() {
        SecureRandom random = new SecureRandom();
        StringBuilder numeroCuenta = new StringBuilder();
        int longitudCuenta = 16;
        for (int i = 0; i < longitudCuenta; i++) {
            int digito = random.nextInt(10);
            numeroCuenta.append(digito);
        }
        return numeroCuenta.toString();
    }

    public UsuarioDTO obteberInformacionUsuario(Long id) {

        Usuario usuario = buscarUsuarioPorId(id);

        return new UsuarioDTO(
                usuario.getPerfil().getNombre(),
                usuario.getCuentas().get(0).getNumeroCuenta(),
                usuario.getCuentas().get(0).getId(),
                usuario.getCuentas().get(0).getBalance()
        );
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public String obtenerIpCliente(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
