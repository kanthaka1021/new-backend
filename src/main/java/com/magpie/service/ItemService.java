package com.magpie.service;

import com.magpie.domain.CombinedInfo;
import com.magpie.domain.DetailItem;
import com.magpie.domain.WeatherInfo;
import com.magpie.jooq.tables.pojos.Item;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class ItemService {
    @Autowired
    ItemRepository repo;

    public Mono<Item> findOne(Integer id) {
        return repo.findOne(id);
    }

    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, Integer fromPrice, Integer toPrice,
                                           String currency) {
        // 1. I will add a procedure convert price into numbers fitting with currency such as Euro.
        // 2. The column 'price' cannot handle cents, so we will discuss how to use column for managing price accurately.
        // Default currency is dollar.

        return repo.findList(seek, limit, fromPrice, toPrice);
    }

}
