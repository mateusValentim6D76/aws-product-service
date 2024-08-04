package br.com.mv.cloud.aws.exception.handler;

import br.com.mv.cloud.aws.exception.ErrorCreateProductException;
import br.com.mv.cloud.aws.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorCreateProductException.class)
    public ResponseEntity<?> handlerErrorCreateProductException(ErrorCreateProductException ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
