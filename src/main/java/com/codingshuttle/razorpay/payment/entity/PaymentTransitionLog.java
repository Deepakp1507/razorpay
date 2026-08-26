package com.codingshuttle.razorpay.payment.entity;

import com.codingshuttle.razorpay.common.enums.PaymentEvent;
import com.codingshuttle.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.*;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_log")
public class PaymentTransitionLog {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, name = "from_status")
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, name = "event")
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false, name = "to_status")
    private  PaymentStatus toStatus;

    @Column(length = 100)
    private  String actor;

    @Column(name = "occured_at", nullable = false)
    private LocalDateTime occuredAt;


}
