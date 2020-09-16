package com.peepopharma.controller;

import com.peepopharma.exception.EntityNotFoundException;
import com.peepopharma.exception.InvalidRequestParametersException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class PharmaResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = InvalidRequestParametersException.class)
  protected ResponseEntity<Object> handleInvalidRequestParameters(Exception e, WebRequest request) {
    log.error(
        "Executed handleInvalidRequestParameters. Invalid request parameters. Further information: {} | Caused by: {} | Stack Trace: {}",
        e.getLocalizedMessage(), e.getCause(), e.getStackTrace());

    return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(value = EntityNotFoundException.class)
  protected ResponseEntity<Object> handleEntityNotFoundException(Exception e, WebRequest request){
    log.error(
        "Executed handleEntityNotFoundException. Entity not found. Further information: {} | Caused by: {} | Stack Trace: {}",
        e.getLocalizedMessage(), e.getCause(), e.getStackTrace());

    return handleExceptionInternal(e, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }


}
