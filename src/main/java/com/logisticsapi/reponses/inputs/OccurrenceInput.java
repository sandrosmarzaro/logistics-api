package com.logisticsapi.reponses.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInput {
    @NotBlank
    private String description;
}

