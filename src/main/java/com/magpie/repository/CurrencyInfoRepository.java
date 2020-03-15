package com.magpie.repository;

import com.magpie.jooq.tables.pojos.CurrencyInfo;
import com.magpie.jooq.tables.records.CurrencyInfoRecord;
import static com.magpie.jooq.tables.CurrencyInfo.CURRENCY_INFO;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

@Repository
@Slf4j
public class CurrencyInfoRepository extends BaseRepository<CurrencyInfoRecord, Table<CurrencyInfoRecord>, CurrencyInfo> {

    @Autowired private DSLContext dsl;

    public Mono<List<CurrencyInfo>> findAll() {
        Supplier<List<CurrencyInfo>> fun = () -> {
          return dsl.selectFrom(CURRENCY_INFO).fetch().into(CurrencyInfo.class);
        };
        log.info("Load currency info from DB.");
        return fetchList(fun);
    }
}
