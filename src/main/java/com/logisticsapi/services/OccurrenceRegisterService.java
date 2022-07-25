package com.logisticsapi.services;

import com.logisticsapi.models.Delivery;
import com.logisticsapi.models.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OccurrenceRegisterService {

    private FindDeliveryService findDeliveryService;

    @Transactional
    public Occurrence register(Long deliveryId, String description) {
        Delivery delivery = findDeliveryService.findDelivery(deliveryId);
        return delivery.addOccurrence(description);
    }
}
