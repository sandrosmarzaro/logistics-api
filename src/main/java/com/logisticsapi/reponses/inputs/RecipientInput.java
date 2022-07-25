package com.logisticsapi.reponses.inputs;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RecipientInput {

    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String number;
    @NotBlank
    private String complement;
    @NotBlank
    private String neighborhood;
}
