package com.logisticsapi.exceptionhandlerers;

import com.logisticsapi.exceptions.DomainException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request
    ) {
        List<ExceptionGenerated.FieldError> fieldErrors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                fieldErrors.add(new ExceptionGenerated.FieldError(
                        error.getField(),
                        messageSource.getMessage(error, LocaleContextHolder.getLocale())
                ))
        );
        ExceptionGenerated exceptionGenerated = new ExceptionGenerated(
                "Invalid values for parameters",
                status.value(),
                OffsetDateTime.now(),
                fieldErrors
        );
        return super.handleExceptionInternal(
                exception,
                exceptionGenerated,
                headers,
                status,
                request
        );
    }
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleEmailException(DomainException exception, WebRequest request) {
        ExceptionGenerated exceptionGenerated = new ExceptionGenerated(
            exception.getMessage(),
            HttpStatus.BAD_REQUEST.value(),
                OffsetDateTime.now(),
            null
        );

        return handleExceptionInternal(
            exception,
            exceptionGenerated,
            new HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            request
        );
    }
}
