package com.magpie.repository;

import com.magpie.jooq.tables.pojos.Country;
import com.magpie.jooq.tables.pojos.User;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import static com.magpie.jooq.tables.User.USER;
import static com.magpie.jooq.tables.Country.COUNTRY;

@Slf4j
@Repository
public class TestNoGenericRepository {
    @Autowired private DSLContext dsl;

    public Mono<User> findUser(Integer id) {
        return Mono.just(dsl.selectFrom(USER).where(USER.ID.eq(id)).fetchOneInto(User.class));
    }

    public Mono<Country> findCountry(String country) {
        return Mono.just(dsl.selectFrom(COUNTRY).where(COUNTRY.CODE.eq(country)).fetchOneInto(Country.class));
    }
}
