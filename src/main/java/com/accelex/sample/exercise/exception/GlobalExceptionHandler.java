package com.accelex.sample.exercise.exception;

import com.accelex.sample.exercise.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> body = new HashMap<>();
        if(ex.getBindingResult().hasErrors()){
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            if(!fieldErrors.isEmpty()){
                for(FieldError e : fieldErrors){
                    body.put(e.getField(),e.getDefaultMessage());
                }
            }else{
                List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
                for(ObjectError e : objectErrors){
                    body.put(e.getObjectName(),e.getDefaultMessage());
                }
            }
        }
        return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseDto> handleException(NoSuchElementException ex){
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("Entity not found"));
    }

}
