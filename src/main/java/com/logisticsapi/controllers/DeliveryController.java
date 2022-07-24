package com.logisticsapi.controllers;

import com.logisticsapi.models.Delivery;
import com.logisticsapi.repositories.DeliveryRepository;
import com.logisticsapi.services.CreateDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private CreateDeliveryService deliveryService;
    private DeliveryRepository deliveryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery create(@Valid @RequestBody Delivery delivery) {
        return deliveryService.create(delivery);
    }

    @GetMapping
    public List<Delivery> readAll() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> readById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
