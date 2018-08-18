package net.MindTree.spring.boot.example.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author prasa
 *
 */
@Controller
public class MyErrorController implements ErrorController  {

    @RequestMapping("/error")
    public String handleError() {
        return "hello";
    }
 
    @Override
    public String getErrorPath() {
        return "/hello";
    }
}
