package com.logisticsapi.services;

import com.logisticsapi.exceptions.NotFoundEntityException;
import com.logisticsapi.models.Delivery;
import com.logisticsapi.repositories.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery findDelivery(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
            .orElseThrow(() -> new NotFoundEntityException("Delivery not found"));
    }
}
