package com.example.tmdb.api;

import com.example.tmdb.exception.InvalidDataException;
import com.example.tmdb.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
public class GlobalExceptionHandler {
    static class Error{
        private final String reason;
        private final String message;

        public Error(String reason, String message) {
            this.reason = reason;
            this.message = message;
        }
    }
    @ExceptionHandler({InvalidDataException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleInvalidDataException(InvalidDataException ex) {
//          log.warn(ex.getMessage());
        return new Error(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNotFoundException(NotFoundException ex) {
//        System.out.println("invalid data ex   ception",ex.getMessage());
//        log.warn(ex.getMessage());
        return new Error(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleUnknownException(Exception ex) {
//        System.out.println("invalid data exception",ex.getMessage());
//        log.warn(ex.getMessage());
        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex.getMessage());
    }
}
