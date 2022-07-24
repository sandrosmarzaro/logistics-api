package com.logisticsapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
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
    @Valid
    @ConvertGroup(to = ValidationGroup.ClientId.class)
    private Client client;

    @Embedded
    @NotNull
    @Valid
    private Recipient recipient;

    @NotNull
    private BigDecimal rate;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private DeliveryStatus status;

    @Column(name = "requestedat")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime requestedAt;

    @Column(name = "finishedat")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime finishedAt;
}
