package com.server.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDetails> globalException(Exception e, WebRequest w){
		ExceptionDetails error = new ExceptionDetails();
		error.setMessage(e.getMessage());
		error.setDescription(w.getDescription(false));
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(true);
		return new ResponseEntity<ExceptionDetails>(error,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ExceptionDetails> globalException(CustomerException e, WebRequest w){
		ExceptionDetails error = new ExceptionDetails();
		error.setMessage(e.getMessage());
		error.setDescription(w.getDescription(false));
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(true);
		return new ResponseEntity<ExceptionDetails>(error,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDetails> globalException(MethodArgumentNotValidException e, WebRequest w){
		ExceptionDetails error = new ExceptionDetails();
		error.setMessage(e.getMessage());
		error.setDescription(w.getDescription(false));
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(true);
		return new ResponseEntity<ExceptionDetails>(error,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDetails> globalException(NoHandlerFoundException e, WebRequest w){
		ExceptionDetails error = new ExceptionDetails();
		error.setMessage(e.getMessage());
		error.setDescription(w.getDescription(false));
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus(true);
		return new ResponseEntity<ExceptionDetails>(error,HttpStatus.BAD_GATEWAY);
	}
	
//	@ExceptionHandler(e.clas)
//	public ResponseEntity<ExceptionDetails> globalException(Exception e, WebRequest w){
//		ExceptionDetails error = new ExceptionDetails();
//		error.setMessage(e.getMessage());
//		error.setDescription(w.getDescription(false));
//		error.setTimeStamp(LocalDateTime.now());
//		
//		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
//	}

}
