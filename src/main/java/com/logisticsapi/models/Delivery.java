package com.logisticsapi.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Client client;

    @Embedded
    @NotNull
    private Recipient recipient;

    @NotNull
    private BigDecimal rate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "requestedat")
    private OffsetDateTime requestedAt;

    @Column(name = "finishedat")
    private OffsetDateTime finishedAt;
}
