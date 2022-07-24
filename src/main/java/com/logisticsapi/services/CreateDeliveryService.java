package com.logisticsapi.services;

import com.logisticsapi.models.Delivery;
import com.logisticsapi.models.DeliveryStatus;
import com.logisticsapi.repositories.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class CreateDeliveryService {

    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    @Transactional
    public Delivery create(Delivery delivery) {

        delivery.setClient(clientService.findById(delivery.getClient().getId()));
        delivery.setStatus(DeliveryStatus.PENDING);
        delivery.setRequestedAt(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
