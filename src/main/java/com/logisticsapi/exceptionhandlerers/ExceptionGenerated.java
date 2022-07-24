package com.logisticsapi.exceptionhandlerers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class ExceptionGenerated {

    private String title;
    private Integer httpStatus;
    private OffsetDateTime timestamp;
    private List<FieldError> fieldErrors;

    @Getter
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String message;
    }
}
