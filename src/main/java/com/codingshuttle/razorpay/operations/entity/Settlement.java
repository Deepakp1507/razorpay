package com.codingshuttle.razorpay.operations.entity;

import com.codingshuttle.razorpay.common.entity.Money;
import com.codingshuttle.razorpay.common.enums.SettlementStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "settlement")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    private  UUID merchantId;

    @Embedded
    @AttributeOverrides ({
        @AttributeOverride(name = "amountUnits", column = @Column(name = "gross_amount_units", nullable = false)),
        @AttributeOverride(name = "currency", column = @Column(name = "gross_amount_currency", nullable = false))
    }) // we did this because otherwise it will create a column with name amountUnits and currency which is not good because we have multiple money fields in this entity so we need to give them different names
    private Money grossAmount;

    @Embedded
    @AttributeOverrides ({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "refund_amount_units", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "refund_amount_currency", nullable = false))
    })
    private Money refundAmount;

    @Embedded
    @AttributeOverrides ({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "gst_amount_units", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "gst_amount_currency", nullable = false))
    })
    private Money gstAmount;


    @Embedded
    @AttributeOverrides ({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "fee_amount_units", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "fee_amount_currency", nullable = false))
    })
    private Money feeAmount;

    @Embedded
    @AttributeOverrides ({
            @AttributeOverride(name = "amountUnits", column = @Column(name = "net_amount_units", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "net_amount_currency", nullable = false))
    })
    private Money netAmount;

    private  String bankReference;

    private LocalDateTime processedAt;

    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private SettlementStatus status;




}
