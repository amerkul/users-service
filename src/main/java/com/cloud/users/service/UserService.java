package com.cloud.users.service;

import com.cloud.users.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> retrieveAll();
    Mono<User> addUser(User user);
}
