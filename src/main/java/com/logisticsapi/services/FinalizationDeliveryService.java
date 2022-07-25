package com.logisticsapi.services;

import com.logisticsapi.models.Delivery;
import com.logisticsapi.repositories.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizationDeliveryService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void finalizeDelivery(Long deliveryId) {
        Delivery delivery = findDeliveryService.findDelivery(deliveryId);
        delivery.finish();
        deliveryRepository.save(delivery);
    }
}
