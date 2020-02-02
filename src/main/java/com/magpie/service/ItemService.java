package com.magpie.service;

import com.magpie.jooq.tables.pojos.Item;
import com.magpie.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class ItemService {
    @Autowired private ItemRepository repo;

    public Mono<Item> findOne(Integer id) {
//        return Mono.defer(() -> Mono.just(repo.findOne(id)));
        return Mono.just(repo.findOne(id));
    }

    public Mono<List<Result<Record>>> getNextHundredByLocation(Integer loc_id, Integer from_id) {
        return Mono.just(getNextHundredByLocation(loc_id, from_id));
    }
}
