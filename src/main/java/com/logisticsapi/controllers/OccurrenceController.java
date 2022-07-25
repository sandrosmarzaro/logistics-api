package com.logisticsapi.controllers;

import com.logisticsapi.mappers.OccurrenceMapper;
import com.logisticsapi.models.Delivery;
import com.logisticsapi.models.Occurrence;
import com.logisticsapi.reponses.OccurrenceResponse;
import com.logisticsapi.reponses.inputs.OccurrenceInput;
import com.logisticsapi.services.FindDeliveryService;
import com.logisticsapi.services.OccurrenceRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

    private OccurrenceRegisterService occurrenceRegisterService;
    private OccurrenceMapper occurrenceMapper;
    private FindDeliveryService findDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceResponse create(
            @PathVariable Long deliveryId,
            @Valid @RequestBody OccurrenceInput input
    ) {
        Occurrence occurrence = occurrenceRegisterService.register(deliveryId, input.getDescription());
        return occurrenceMapper.map(occurrence);
    }

    @GetMapping
    public List<OccurrenceResponse> readAll(@PathVariable Long deliveryId) {
        Delivery delivery = findDeliveryService.findDelivery(deliveryId);
        return occurrenceMapper.mapAll(delivery.getOccurrences());
    }
}
