package com.magpie.repository;

import com.magpie.jooq.tables.pojos.User;
import com.magpie.jooq.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.magpie.jooq.tables.User.USER;

@Repository
public class UserRepository {
    @Autowired private DSLContext dsl;

    public User findOne(Integer id) {
        return dsl.selectFrom(USER).where(USER.ID.eq(id)).fetchOneInto(User.class);
    }

    public Integer save(User u) {
        UserRecord record = new UserRecord();
        record.setId(u.getId());
        record.setName(u.getName());
        record.setAccount(u.getAccount());
        return dsl.insertInto(USER).set(record).execute();
    }

    public Integer update(User u) {
        UserRecord ur = dsl.newRecord(USER, u);
        return dsl.update(USER).set(ur).where(USER.ID.eq(u.getId())).execute();
        //return dsl.update(USER).set(ur).execute();
    }
}
