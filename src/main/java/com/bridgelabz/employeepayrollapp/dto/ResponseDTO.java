package com.bridgelabz.employeepayrollapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Purpose - To define format for ResponseDto
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 08-12-21
 */
@Getter
@Setter
public class ResponseDTO {
    private Date timestamp;
    private String message;
    private String details;

    public ResponseDTO(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
