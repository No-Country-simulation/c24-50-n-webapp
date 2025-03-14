package com.nobank.domain.usuario;

import com.nobank.domain.cuenta.Cuenta;
import com.nobank.domain.perfil.Perfil;
import com.nobank.domain.rolTipo.RolTipo;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column(nullable = false)
    private String contraseñaHash;

    @Column(nullable = false)
    private Boolean estado = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_tipo_id", nullable = false)
    private RolTipo rolTipo;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuenta> cuentas;

    @Column(nullable = false)
    private Integer intentosFallidos = 0;

    @Column(nullable = true)
    private String ipUltimaConexion;

    public Usuario(String dni, String contraseñaHash, RolTipo rolTipo, String ipUltimaConexion) {
        this.dni = dni;
        this.contraseñaHash = contraseñaHash;
        this.rolTipo = rolTipo;
        this.estado = true;
        this.ipUltimaConexion = ipUltimaConexion;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contraseñaHash;
    }

    @Override
    public String getUsername() {
        return dni;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void incrementarIntentosFallidos() {
        this.intentosFallidos++;
    }

    public void resetIntentosFallidos() {
        this.intentosFallidos = 0;
    }
}



