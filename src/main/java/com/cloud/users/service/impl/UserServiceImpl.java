package com.cloud.users.service.impl;

import com.cloud.users.domain.User;
import com.cloud.users.repository.UserRepository;
import com.cloud.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Flux<User> retrieveAll() {
        return repository.findAll();
    }

    @Override
    public Mono<User> addUser(User user) {
        return repository.save(user);
    }

}
