package com.framework.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // You can customize the response status based on error.
    public String handleError() {
        // Log error details here if you need to.
        return "error"; // View name for error page
    }

    //@Override
    public String getErrorPath() {
        return "/error";
    }
}
