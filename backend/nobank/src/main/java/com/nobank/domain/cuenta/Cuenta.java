package com.nobank.domain.cuenta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nobank.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "cuenta")
@Table(name = "cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "numero_cuenta", unique = true, nullable = false)
    private String numeroCuenta;
    private BigDecimal balance;
    private Boolean estado = true;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Cuenta(Usuario usuario , String numero_cuenta){
        this.numeroCuenta = numero_cuenta;
        this.balance = new BigDecimal(0);
        this.usuario = usuario;
        this.estado = true;
    }


}
