package com.codingshuttle.razorpay.operations.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "dlq_event")
// This is also for auditing purpose of the DLQ events.
public class DlqEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private  UUID merchantId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private  WebhookEvent webhookEvent;


    private  String finalError;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "json", nullable = false)
    private Map<String,Object> payload;


    private LocalDateTime movedAt;

    private LocalDateTime replayedAt;

}
