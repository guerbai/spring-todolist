package guerbai.springtodolist.controller;

import guerbai.springtodolist.domain.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler
    public ResponseEntity defaultErrorController(HttpServletRequest req, Exception e) throws  Exception {
        logger.error(e.toString(), e);
        return new ErrorResponse();
    }
}
