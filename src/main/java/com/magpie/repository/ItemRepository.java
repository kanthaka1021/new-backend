package com.magpie.repository;

import com.magpie.jooq.tables.Item;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.magpie.jooq.tables.Item.ITEM;

@Repository
public class ItemRepository {
    @Autowired
    private DSLContext dsl;

    public Item findOne(Integer id) {
        return dsl.selectFrom(ITEM).where(ITEM.ID.eq(id)).fetchOneInto(Item.class);
    }

    public List<Result<Record>> getNextHundredByLocation(Integer loc_id, Integer from_id) {
        return dsl.selectFrom(ITEM)
                .where(ITEM.LOCATION_ID.eq(loc_id))
                .orderBy(ITEM.ID.desc())
                .seek(from_id)
                .limit(100)
                .fetchMany();
    }
}
