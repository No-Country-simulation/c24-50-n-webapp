package com.nobank.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account")
    private Account account;

    private String destinationAccount;

    private Double amount;
    private LocalDateTime date;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
