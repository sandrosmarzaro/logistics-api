package com.logisticsapi.mappers;

import com.logisticsapi.models.Occurrence;
import com.logisticsapi.reponses.OccurrenceResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceResponse map(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceResponse.class);
    }

    public List<OccurrenceResponse> mapAll(List<Occurrence> occurrences) {
        return occurrences.stream()
            .map(this::map)
            .collect(Collectors.toList());
    }
}
