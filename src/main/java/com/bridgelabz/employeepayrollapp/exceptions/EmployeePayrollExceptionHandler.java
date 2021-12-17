package com.bridgelabz.employeepayrollapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose - To handle Runtime Exceptions
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@ControllerAdvice
public class EmployeePayrollExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Purpose - To handle exceptions thrown at Run time
     *
     * @param ex      : Exception is thrown during validation
     * @param headers : It gives additional information for client and server through request and response body
     * @param status  : It helps to identify status of the error when web page is not loaded properly
     * @param request : Help identify the cause of the problem when a web page or
     *                other resource does not load properly.
     * @return : It returns body,headers and status
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }

    /**
     * Purpose - To create custom exception if id is not found
     *
     * @param ex : entity not found exception is taken as input
     * @return : It contains String message and Http status
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        logger.error("Invalid ID");
        return new ResponseEntity("Given id is Not Found", HttpStatus.BAD_REQUEST);
    }

}
