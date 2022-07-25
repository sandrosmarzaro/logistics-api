package com.logisticsapi.reponses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientResponse {

    private String name;
    private String address;
    private String number;
    private String complement;
    private String neighborhood;
}
