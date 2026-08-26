package com.codingshuttle.razorpay.merchant.entity;

import com.codingshuttle.razorpay.common.enums.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class Appuser {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private  String email;

    @Column(nullable = false)
    private  String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private  Merchant merchant; //Merchant entity is used to establish a relationship between the user and the merchant. Each user belongs to a merchant, and this relationship is represented by the foreign key merchant_id in the app_user table.


}
