package com.magpie.service;

import com.magpie.jooq.tables.pojos.User;
import com.magpie.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {
    @Autowired private UserRepository repo;

    public Mono<User> findOne(Integer id) {
        Mono<User> m2 = Mono.defer(() -> Mono.just(repo.findOne(id)));
        log.info("this line");
        return m2;
    }

    public Mono<Integer> save(User u) {
        return Mono.just(repo.save(u));
    }

    public Mono<Integer> update(User u) {
        return Mono.just(repo.update(u));
    }
}
