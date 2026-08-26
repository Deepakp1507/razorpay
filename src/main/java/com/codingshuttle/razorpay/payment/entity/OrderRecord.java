package com.codingshuttle.razorpay.payment.entity;

import com.codingshuttle.razorpay.common.entity.Money;
import com.codingshuttle.razorpay.common.enums.OrderStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "order_record")
public class OrderRecord {

    @Id
    private UUID id;

    @Column(name = "merchant_id", nullable = false)
    private  UUID merchantId;

    @Embedded // Since money class is embeddable,So in this order record table, there will be two more columns in the table(which are the columns of Money class
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private OrderStatus orderStatus = OrderStatus.CREATED;

    @Column(nullable = false)
    private  Integer attempts=0;


    @JdbcTypeCode(SqlTypes.JSON) // it helps to convert the json stored in the db to map
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> notes;

    @Column(nullable = false,name = "expires_at")
    private LocalDateTime expiresAt;
}
