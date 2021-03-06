package com.magpie.repository;

import com.magpie.jooq.tables.pojos.TestDummy;
import static com.magpie.jooq.tables.TestDummy.TEST_DUMMY;
import com.magpie.jooq.tables.records.TestDummyRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Repository
public class TestRepository
        implements
        SelectRepository<TestDummyRecord>,
        InsertRepository<TestDummyRecord,
                Table<TestDummyRecord>> {
    @Autowired
    private DSLContext dsl;

    public Mono<TestDummy> findOne(Integer id) {
        SelectConditionStep<TestDummyRecord> condition = dsl.selectFrom(TEST_DUMMY).where(TEST_DUMMY.ID.eq(id));
        try {
            return fetchMono(dsl, condition).map(r -> r.into(TestDummy.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Mono.error(e);
        }
    }

    public Mono<List<TestDummy>> findList(Integer seek, Integer limit, String name) {
        try {
            Result<TestDummyRecord> result
                    = dsl.selectFrom(TEST_DUMMY)
                    .where(TEST_DUMMY.NAME.like(name+'%'))
                    .orderBy(TEST_DUMMY.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .fetch();

            String sql = dsl.selectFrom(TEST_DUMMY)
                    .where(TEST_DUMMY.NAME.like(name+'%'))
                    .orderBy(TEST_DUMMY.ID.asc())
                    .seekAfter(seek)
                    .limit(limit).getSQL();
            System.out.println(sql);
            List<TestDummy> list = result.into(TestDummy.class);
            return Mono.just(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Mono.error(e);
        }
    }

    public Mono<TestDummy> save(TestDummy dummy) {
        try {
            TestDummyRecord record = dsl.newRecord(TEST_DUMMY, dummy);
            return insertMono(dsl, record, TEST_DUMMY).map(r -> r.into(TestDummy.class));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }


}
