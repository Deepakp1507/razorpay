package com.codingshuttle.razorpay.merchant.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private UUID id;

    @Column(length = 200)
    private  String name;

    @Column(length = 200)
    private  String email;

    @Column(length = 20)
    private String contactNumber;

    private LocalDateTime deletedAt;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) /* Not ManyToMany because we want to manage isolation, if we did this, then all merchant will have access to all data, suppose one customer gave some info to zara
    and not to h&m, then h&m should not have access to that data, so we need to manage isolation, so we will use ManyToOne */
    @JoinColumn(name = "merchant_id", nullable = false)
    private  Merchant merchant;


}
