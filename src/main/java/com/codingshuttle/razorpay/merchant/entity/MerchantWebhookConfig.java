package com.codingshuttle.razorpay.merchant.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant_webhook_config")
public class MerchantWebhookConfig {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(length = 500, nullable = false)
    private String targetUrl; //eg: https://myapp.com/webhook/success

    private String webhookSecretHash; // This is to sign the webhook to verify the webhook is from razorpay

    @Column(nullable = false)
    private boolean enabled;

    private String eventTypes; // This is to store the event types for which the webhook is enabled





}
