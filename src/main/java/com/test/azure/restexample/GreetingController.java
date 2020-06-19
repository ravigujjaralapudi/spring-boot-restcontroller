package com.test.azure.restexample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/spanish-greetings")
public class GreetingController {

    private List<Greeting> spanishGreetings;

    public GreetingController() {
        spanishGreetings = new ArrayList<>();
        spanishGreetings.add(new Greeting("Hello World"));
        spanishGreetings.add(new Greeting("Hellow Azure"));
        spanishGreetings.add(new Greeting("Hello Spring Boot"));
    }

    @GetMapping("/{id}")
    public Greeting getSpanishGreetingById(@PathVariable("id") final int id) {
        return spanishGreetings.get(id - 1); // list index starts with 0 but we prefer to start on 1
    }

    @GetMapping("/random")
    public Greeting getRandom() {
        return spanishGreetings.get(new Random().nextInt(spanishGreetings.size()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createSpanishGreeting(@RequestBody Greeting spanishGreeting) {
        spanishGreetings.add(spanishGreeting);
    }
}
