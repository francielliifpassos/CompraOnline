package ifsuldeminas.bcc.CompraOnline.resources.comercial;

import ifsuldeminas.bcc.CompraOnline.exceptions.comercial.ProdutoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProdutoResourceAdvice {
    @ResponseBody
    @ExceptionHandler(ProdutoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String produtoNotFoundHandler(ProdutoNotFoundException pe){
        return pe.getMessage();
    }
}
