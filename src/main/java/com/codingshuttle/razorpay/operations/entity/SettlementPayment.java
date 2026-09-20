package com.codingshuttle.razorpay.operations.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "settlement_payment")
public class SettlementPayment {
    /* With the help of Embeddable key we can create composite key,
    we created a settlementPaymentID class, which has two attributes and now we will embedd it here and it will work as a primary key
     */

    @EmbeddedId //This will tell JPA that this is a composite primary key and it will use the SettlementPaymentId class to create the primary key
    private  SettlementPaymentId id;

    @MapsId() // This will tell JPA that the settlementId in the SettlementPaymentId class is mapped to the settlement attribute in this class
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "settlement_id", nullable = false)
   private  Settlement settlement;
}
