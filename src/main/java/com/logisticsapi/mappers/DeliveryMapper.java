package com.logisticsapi.mappers;

import com.logisticsapi.models.Delivery;
import com.logisticsapi.reponses.DeliveryResponse;
import com.logisticsapi.reponses.inputs.DeliveryInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryResponse map(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryResponse.class);
    }

    public List<DeliveryResponse> mapAll(List<Delivery> deliveries) {
        return deliveries.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }

    public Delivery map(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
