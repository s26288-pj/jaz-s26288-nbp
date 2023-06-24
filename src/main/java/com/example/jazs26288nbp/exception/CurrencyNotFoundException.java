package com.example.jazs26288nbp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Currency not found")
public class CurrencyNotFoundException extends Exception{
}
