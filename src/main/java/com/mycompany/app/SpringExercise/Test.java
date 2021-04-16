package com.mycompany.app.SpringExercise;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/")
    public String hello(){
        return  "Hello this is Eunice and I love cats!";
    }
}
