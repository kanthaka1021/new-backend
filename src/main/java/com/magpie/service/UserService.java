package com.magpie.service;

import com.magpie.jooq.tables.pojos.User;
import com.magpie.repository.AdvancedUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired private AdvancedUserRepository repo;

    public Mono<User> findOne(Integer id) {
        return repo.findOne(id);
    }

    public Mono<List<User>> findAllByCountry(String country, Integer offset, Integer limit) {
        return repo.findAllByCountry(country, offset, limit);
    }

    public Mono<Integer> save(User u) {
        return repo.save(u);
    }

    public Mono<Long> saveBulk(List<User> users) {
        return repo.saveBulk(users);
    }

    public Mono<Integer> update(User u) {
        return repo.update(u);
    }
}
