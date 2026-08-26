package com.codingshuttle.razorpay.payment.entity;

import com.codingshuttle.razorpay.common.entity.Money;
import com.codingshuttle.razorpay.common.enums.PaymentMethod;
import com.codingshuttle.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Embedded
    private Money amount;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private  OrderRecord order;

    @Column(nullable = false)
    private  UUID merchantId;
    @Column(nullable = false ,length = 100)
    private String idempotencyKey;
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private PaymentStatus status;

    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Column(length = 100)
    private  String bankReference;

    private  String failedReason;

    @Column(columnDefinition = "jsonb" , name = "method_details")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> methodDetails;

    @Column(length = 100)
    private  String errorCode;

    @Column(length = 300)
    private String errorDescription;

    private LocalDateTime authorizedAt;

    private  LocalDateTime capturedAt;

    private LocalDateTime failedAt;

    private LocalDateTime refundedAt;

    private LocalDateTime settledAt;





}


