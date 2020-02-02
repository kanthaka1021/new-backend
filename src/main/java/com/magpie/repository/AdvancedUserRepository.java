package com.magpie.repository;

import com.magpie.jooq.tables.pojos.User;
import com.magpie.jooq.tables.records.UserRecord;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.magpie.jooq.tables.User.USER;

@Repository
public class AdvancedUserRepository extends BaseRepository<UserRecord, Table<UserRecord>, User> {
    @Autowired private DSLContext dsl;

    public Mono<User> findOne(Integer id) {
        Supplier<User> f = () -> {
            return dsl.selectFrom(USER).where(USER.ID.eq(id)).fetchOneInto(User.class);
        };
        return fetchOne(f);
    }

    public Mono<List<User>> findAllByCountry(String country, Integer offset, Integer limit) {

        Supplier<List<User>> f = () -> {
            return dsl.selectFrom(USER).where(USER.COUNTRY_CODE.eq(country)).offset((int) offset)
                    .limit(limit).fetchInto(User.class);
        };
        return fetchList(f);
    }

    public Mono<Integer> save(User u) {
        Supplier<Integer> f = () -> {
            return dsl.insertInto(USER).set(dsl.newRecord(USER, u)).execute();
        };
        return modify(f);
    }

    public Mono<Long> saveBulk(List<User> list) {
        Function<List<UserRecord>, Long> func = (List<UserRecord> rlist) -> {
            return reduceInserts(dsl.batchInsert(rlist).execute());
        };

        Function<List<User>, List<UserRecord>> func2 = (List<User> ulist) -> {
            return ulist.stream().map(s -> dsl.newRecord(USER, s)).collect(Collectors.toList());
        };

        return insertBulk(list, func, func2);
    }

    public Mono<Integer> update(User u) {
        Supplier<Integer> f = () -> {
            return dsl.update(USER).set(dsl.newRecord(USER, u)).where(USER.ID.eq(u.getId())).execute();
        };
        return modify(f);
    }

    private List<UserRecord> convertIntoRecords(List<User> list) {
        return list.stream().map(s -> dsl.newRecord(USER, s)).collect(Collectors.toList());
    }
}
