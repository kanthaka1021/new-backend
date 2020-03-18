package com.magpie.repository;

import com.magpie.domain.DetailItem;
import com.magpie.jooq.tables.pojos.Items;
import com.magpie.jooq.tables.records.ItemsRecord;
import com.magpie.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;

import static com.magpie.jooq.tables.Items.ITEMS;
import static com.magpie.jooq.tables.Category.CATEGORY;
import static com.magpie.jooq.tables.Location.LOCATION;

@Repository
@Slf4j
public class ItemRepository
        implements SelectRepository<ItemsRecord>, InsertRepository<ItemsRecord, Table<ItemsRecord>> {
    @Autowired
    private DSLContext dsl;

    // Find an item by id
    public Mono<List<DetailItem>> findOne(Integer id) {
        try {
            Result<Record8<Integer, String, String, BigDecimal, String, Integer, Integer, String>> result
                    = dsl.select(ITEMS.ID, ITEMS.NAME, ITEMS.DESC, ITEMS.PRICE, CATEGORY.NAME, CATEGORY.ID,
                    LOCATION.ID, LOCATION.NAME)
                    .from(ITEMS)
                    .join(CATEGORY).onKey()
                    .join(LOCATION).onKey()
                    .where(ITEMS.ID.eq(id))
                    .fetch();
            return Mono.just(result.into(DetailItem.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.error(e);
        }
    }

    // Find a list joining item and category
    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, BigDecimal fromPrice, BigDecimal toPrice) {
        try {
            Result<Record8<Integer, String, String, BigDecimal, String, Integer, Integer, String>> result
                    = dsl.select(ITEMS.ID, ITEMS.NAME, ITEMS.DESC, ITEMS.PRICE, CATEGORY.NAME, CATEGORY.ID,
                    LOCATION.ID, LOCATION.NAME)
                    .from(ITEMS).join(CATEGORY)
                    .on(CATEGORY.ID.eq(ITEMS.CAT_ID))
                    .join(LOCATION).onKey()
                    .where(ITEMS.PRICE.greaterOrEqual(fromPrice).and(ITEMS.PRICE.lessOrEqual(toPrice)))
                    .orderBy(ITEMS.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .fetch();
            String sql = dsl.select(ITEMS.ID, ITEMS.NAME, ITEMS.DESC, ITEMS.PRICE, CATEGORY.NAME)
                    .from(ITEMS).join(CATEGORY)
                    .on(CATEGORY.ID.eq(ITEMS.CAT_ID))
                    .where(ITEMS.PRICE.gt(fromPrice).and(ITEMS.PRICE.lt(toPrice)))
                    .orderBy(ITEMS.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .getSQL();
            log.info(sql);
            List<DetailItem> list = result.into(DetailItem.class);
            return Mono.just(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Mono.error(e);
        }
    }

    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, Integer locationId) {
        try {
            Result<Record8<Integer, String, String, BigDecimal, String, Integer, Integer, String>> result
                    = dsl.select(ITEMS.ID, ITEMS.NAME, ITEMS.DESC, ITEMS.PRICE, CATEGORY.NAME, CATEGORY.ID,
                    LOCATION.ID, LOCATION.NAME)
                    .from(ITEMS)
                    .join(CATEGORY).onKey()
                    .join(LOCATION).onKey()
                    .where(ITEMS.LOCATION_ID.eq(locationId))
                    .orderBy(ITEMS.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .fetch();
            return Mono.just(result.into(DetailItem.class));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    public Mono<Integer> save(DetailItem item) {
        return Mono.just(dsl.insertInto(ITEMS).set(dsl.newRecord(ITEMS, item)).execute());
    }
}
