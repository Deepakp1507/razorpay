package com.codingshuttle.razorpay.vault.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "card_token")
public class CardToken {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false, unique = true)
    private  String token; /* we store card in card vault, vault will return a token for that card, we will store that token in this table, and we will use that token to make payment
      so to trace a card and PAN back you cant ake this token to vault and only then you can get the info ,so the info is unknown which is good for PCI DSS compliance */

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vault_card_id", nullable = false)
    private  VaultCard vaultCard;

    @Column(length = 100, nullable = false)
    private  UUID customer;

    @Column(length = 100, nullable = false)
    private  UUID merchant;

    private LocalDateTime revokedAt;

}
