package com.codingshuttle.razorpay.merchant.entity;


import com.codingshuttle.razorpay.common.enums.Environment;
import jakarta.persistence.*;

import java.util.UUID;



@Entity
@Table(name = "api_key")
// This entity is basically for razor pay to know that which merchant is it talking to, so When a merchant onboards it creates these keys and store it on the server, and it is not exposed
// Zara can also sign the payload it sends to the Razorpay using the keySecretHAsh. This will tell Razorpay tht request is coming from the merchant and not from any other source. This is basically for security purpose.
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private  Merchant merchant;

    @Column(length = 100, nullable = false,unique = true)
    private  String key_id;

    @Column(nullable = false,length = 200)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Environment environment;

    @Column(nullable = false)
    private  boolean enabled = true;

    private  java.time.LocalDateTime lastUsedAt;

    private  java.time.LocalDateTime rotatedAt;

    private java.time.LocalDateTime gracePeriodExpiresAt;
}
