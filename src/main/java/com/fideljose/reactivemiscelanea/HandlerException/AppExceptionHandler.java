package com.fideljose.reactivemiscelanea.HandlerException;

import java.io.FileNotFoundException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	CustomErrorMessage customErrorMessage;
	
	@ExceptionHandler(value = FileNotFoundException.class)
	public ResponseEntity<Object> handlerFileNotFoundException(Exception ex, WebRequest request){
		customErrorMessage.setMessage(ex.toString());
		customErrorMessage.setTimestamp(new Date());
		customErrorMessage.setCustom("Archivo No Encontrado!!!");
		return new ResponseEntity<>(
				customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> handlerNullPointerException(Exception ex, WebRequest request){
		customErrorMessage.setMessage(ex.toString());
		customErrorMessage.setTimestamp(new Date());
		customErrorMessage.setCustom("Ops, La Instancia Es Nula!!!");
		return new ResponseEntity<>(
				customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handlerAnyOtherException(Exception ex, WebRequest request){
		customErrorMessage.setMessage(ex.toString());
		customErrorMessage.setTimestamp(new Date());
		customErrorMessage.setCustom("Uhhh, Error 500!!!");
		return new ResponseEntity<>(
				customErrorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
