package com.inditex.zara.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/** ProductNotFoundException. */
@EqualsAndHashCode(callSuper = true)
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PriceNotFoundException extends Exception{

    private String errorCode;
    private String description;
    private String detail;
    @Serial
    private static final long serialVersionUID = -4190114665337182606L;

    public PriceNotFoundException(String message){
        setDescription(message);

    }

}
