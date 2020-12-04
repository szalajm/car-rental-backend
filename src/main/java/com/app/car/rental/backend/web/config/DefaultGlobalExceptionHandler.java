package com.app.car.rental.backend.web.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DefaultGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAvisApiException(Exception e) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("message", e.getMessage());
        mav.setViewName("error");

        return mav;
    }
}
