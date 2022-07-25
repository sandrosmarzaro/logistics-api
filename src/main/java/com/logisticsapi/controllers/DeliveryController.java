package com.logisticsapi.controllers;

import com.logisticsapi.mappers.DeliveryMapper;
import com.logisticsapi.models.Delivery;
import com.logisticsapi.reponses.DeliveryResponse;
import com.logisticsapi.reponses.inputs.DeliveryInput;
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
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponse create(@Valid @RequestBody DeliveryInput delivery) {
        Delivery createdDelivery = deliveryMapper.map(delivery);
        return deliveryMapper.map(deliveryService.create(createdDelivery));
    }

    @GetMapping
    public List<DeliveryResponse> readAll() {
        return deliveryMapper.mapAll(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponse> readById(@PathVariable Long id) {
        return deliveryRepository.findById(id)
            .map(delivery -> ResponseEntity.ok(deliveryMapper.map(delivery)))
            .orElse(ResponseEntity.notFound().build());
    }
}
