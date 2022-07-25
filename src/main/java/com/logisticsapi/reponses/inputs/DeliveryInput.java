package com.logisticsapi.reponses.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryInput {

    @Valid
    @NotNull
    private ClientIdInput client;
    @Valid
    @NotNull
    private RecipientInput recipient;
    @Valid
    @NotNull
    private BigDecimal rate;
}
