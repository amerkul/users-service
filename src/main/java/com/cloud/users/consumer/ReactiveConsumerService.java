package com.cloud.users.consumer;

import com.cloud.users.domain.User;
import com.cloud.users.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReactiveConsumerService {

    private final ReactiveKafkaConsumerTemplate<String, User> consumerTemplate;
    private final UserService service;

    @PostConstruct
    public void init() {
        consumerTemplate.receive()
                        .subscribe(userRecord -> {
                            service.addUser(userRecord.value());
                            userRecord.receiverOffset()
                                      .acknowledge();
                        });
    }

}
