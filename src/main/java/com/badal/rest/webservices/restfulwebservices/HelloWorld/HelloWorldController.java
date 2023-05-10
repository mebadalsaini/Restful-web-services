package com.badal.rest.webservices.restfulwebservices.HelloWorld;

import com.badal.rest.webservices.restfulwebservices.Entity.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hi")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(path = "/hi-there")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World! Welcome to SpringBoot");
    }

    @GetMapping(path = "/hi-there/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello %s Welcome to SpringBoot!", name));
    }
}
