package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import DTO.BaseDTO;
import DTO.EmptyDTO;

@RestControllerAdvice
public class GlobleException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<BaseDTO<EmptyDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BaseDTO<EmptyDTO> response = new BaseDTO<>();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setErrorString(ex.getBindingResult().getFieldError().getDefaultMessage());
        response.setData(null); 

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
