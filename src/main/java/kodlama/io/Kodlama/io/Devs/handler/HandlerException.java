package kodlama.io.Kodlama.io.Devs.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Current TimeStamp",new Date());
        objectBody.put("Status",status.value());

        // GetAll Errors

        List<String> exceptionalErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x->x.getDefaultMessage())
                .collect(Collectors.toList());

        objectBody.put("Errors",exceptionalErrors);
        return new ResponseEntity<>(objectBody,status);
    }
}
