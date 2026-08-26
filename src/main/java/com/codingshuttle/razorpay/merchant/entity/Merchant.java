package com.codingshuttle.razorpay.merchant.entity;

import com.codingshuttle.razorpay.common.enums.BusinessType;
import com.codingshuttle.razorpay.common.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; // UUID because it is a unique identifier for the merchant and helps to maintain privacy

    @Column(nullable = false, length = 200)
    private  String name;

    @Column(unique = true, nullable = false, length = 200)
    private String email;

    @Column(length = 20)
    private String contactNumber;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 100)
    private  String businessName;

    @Column(length = 300)
    private String websiteUrl;

    @Column(length = 100, nullable = false)
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private MerchantStatus status = MerchantStatus.PENDING_KYC;

    @Column(length = 30)
    private String gstId;

    @Column(length = 30)
    private String panId;

    @Column(length = 300)
    private String settlementBankAccount;

    @Column(length = 30)
    private  String settlementBankIfsc;

    @Column(length = 300)
    private  String settlementBankAccountHolderName;

}
