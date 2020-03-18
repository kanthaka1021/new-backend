package com.magpie.repository;
import com.magpie.jooq.tables.pojos.Location;
import com.magpie.jooq.tables.records.LocationRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import java.util.List;

import static com.magpie.jooq.tables.Location.LOCATION;

@Repository
public class LocationRepository {
    @Autowired private DSLContext dsl;

    public Mono<List<Location>> getLocations() {
        try {
            Result<Record2<Integer, String>> result
                    = dsl.select(LOCATION.ID, LOCATION.NAME)
                    .from(LOCATION)
                    .fetch();
            return Mono.just(result.into(Location.class));
        } catch (Exception e) {
            e.printStackTrace();
            return Mono.error(e);
        }
    }
}
