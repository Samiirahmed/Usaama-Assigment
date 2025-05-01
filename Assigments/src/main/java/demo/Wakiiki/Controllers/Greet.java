package demo.Wakiiki.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greet {

    @GetMapping("/")
    public String greet (){
        return "Hello Spring Boot";
    }

    @GetMapping("/greet/{name}")
    public String GreetingByName(@PathVariable String name){
        return "I Am Eng "+name;
    }
}
