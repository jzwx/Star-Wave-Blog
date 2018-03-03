package com.jzwx.spring.boot.blog.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController 控制器
 *
 * @author jzwx
 * @version $ Id: HelloController, v 0.1 2018/1/27 21:13 jzwx Exp $
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String hello(){
        return "Hello world!";
    }
}
