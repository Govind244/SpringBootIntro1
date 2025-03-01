package com.FirstProject.myFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class HelloController {

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    // UC 2: GET Method - Pass name as Query Parameter
    @GetMapping("/hello/query")
    public String sayHelloWithName(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }

    // UC 3: GET Method - Pass name as Path Variable
    @GetMapping("/hello/{name}")
    public String sayHelloWithPath(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // UC 4: POST Method - Pass firstName and lastName in the Body
    @PostMapping("/hello")
    public String sayHelloWithBody(@RequestBody User user) {
        return "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
    }

    // UC 5: PUT Method - Pass first name as Path Variable and last name as Query Parameter
    @PutMapping("/hello/{firstName}")
    public String updateHello(@PathVariable String firstName, @RequestParam(name = "lastName") String lastName) {
        return "Hello, " + firstName + " " + lastName + "!";
    }
}

// User class to hold firstName and lastName
class User {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
