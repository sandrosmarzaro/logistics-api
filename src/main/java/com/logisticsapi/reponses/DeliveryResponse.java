package com.logisticsapi.reponses;

import com.logisticsapi.models.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryResponse {

    private Long id;
    private ClientSummaryResponse client;
    private RecipientResponse recipient;
    private BigDecimal rate;
    private DeliveryStatus status;
    private OffsetDateTime requestedAt;
    private OffsetDateTime finishedAt;
}
