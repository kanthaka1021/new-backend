package com.magpie.repository;

import com.magpie.jooq.tables.pojos.User;
import com.magpie.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.magpie.jooq.tables.User.USER;

@Repository
public class UserRepository extends BaseRepository<UserRecord, Table<UserRecord>, User> {
    @Autowired private DSLContext dsl;

    public User findOne(Integer id) {
        return dsl.selectFrom(USER).where(USER.ID.eq(id)).fetchOneInto(User.class);
    }

    public Mono<User> advFindOneByIdAndCountry(Integer id, String country) {
        Supplier<User> f = () -> {
          return dsl.selectFrom(USER).where(USER.ID.eq(id)).and(USER.COUNTRY_CODE.eq(country))
                  .fetchOneInto(User.class);

        };
        return fetchOne(f);
    }

    public User findOneByCountry(Integer id, String country) {
        return dsl.selectFrom(USER).where(USER.ID.eq(id)).and(USER.COUNTRY_CODE.eq(country))
                .fetchOneInto(User.class);
    }

    public Integer save(User u) {
        UserRecord record = new UserRecord();
        record.setId(u.getId());
        record.setName(u.getName());
        record.setAccount(u.getAccount());
        return dsl.insertInto(USER).set(record).execute();
    }

    public Mono<Integer> saveAdv(User u) {
        UserRecord ur = dsl.newRecord(USER, u);
        Supplier<Integer> f = () -> {
            return dsl.insertInto(USER).set(ur).execute();
        };

        return modify(f);
    }

    public Mono<Integer> updateAdv(User u) {
        UserRecord ur = dsl.newRecord(USER, u);
        Supplier<Integer> f = () -> {
            return dsl.update(USER).set(ur).where(USER.ID.eq(u.getId())).execute();
        };

        return modify(f);
    }


    public Integer update(User u) {
        UserRecord ur = dsl.newRecord(USER, u);
        return dsl.update(USER).set(ur).where(USER.ID.eq(u.getId())).execute();
        //return dsl.update(USER).set(ur).execute();
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
}
