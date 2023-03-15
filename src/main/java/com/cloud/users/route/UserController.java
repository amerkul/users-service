package com.cloud.users.route;

import com.cloud.users.domain.User;
import com.cloud.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAll() {
        return service.retrieveAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        return service.addUser(user);
    }

}
