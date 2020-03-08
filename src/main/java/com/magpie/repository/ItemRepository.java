package com.magpie.repository;

import com.magpie.domain.DetailItem;
import com.magpie.jooq.tables.pojos.Item;
import com.magpie.jooq.tables.records.ItemRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.magpie.jooq.tables.Item.ITEM;
import static com.magpie.jooq.tables.Category.CATEGORY;

@Slf4j
@Repository
public class ItemRepository
        implements SelectRepository<ItemRecord>, InsertRepository<ItemRecord, Table<ItemRecord>> {
    @Autowired
    private DSLContext dsl;

    // Find an item by id
    public Mono<Item> findOne(Integer id) {
        SelectConditionStep<ItemRecord> condition = dsl.selectFrom(ITEM).where(ITEM.ID.eq(id));
        try {
            return fetchMono(dsl, condition).map(r -> r.into(Item.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Mono.error(e);
        }
    }

    // Find a list joining item and category
    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, Integer fromPrice, Integer toPrice) {
        try {
            Result<Record5<Integer, String, String, Integer, String>> result
                    = dsl.select(ITEM.ID, ITEM.NAME, ITEM.DESC, ITEM.PRICE, CATEGORY.NAME)
                    .from(ITEM).join(CATEGORY)
                    .on(CATEGORY.ID.eq(ITEM.CAT_ID))
                    .where(ITEM.PRICE.gt(fromPrice).and(ITEM.PRICE.lt(toPrice)))
                    .orderBy(ITEM.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .fetch();
            String sql = dsl.select(ITEM.ID, ITEM.NAME, ITEM.DESC, ITEM.PRICE, CATEGORY.NAME)
                    .from(ITEM).join(CATEGORY)
                    .on(CATEGORY.ID.eq(ITEM.CAT_ID))
                    .where(ITEM.PRICE.gt(fromPrice).and(ITEM.PRICE.lt(toPrice)))
                    .orderBy(ITEM.ID.asc())
                    .seek(seek)
                    .limit(limit)
                    .getSQL();
            System.out.println(sql);
            List<DetailItem> list = result.into(DetailItem.class);
            return Mono.just(list);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Mono.error(e);
        }
    }
}
