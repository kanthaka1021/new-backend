package com.magpie.service;

import com.magpie.domain.DetailItem;
import com.magpie.jooq.tables.pojos.Items;
import com.magpie.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ItemService {
    @Autowired
    ItemRepository repo;

    private String currentCurrency = "USD";
    @Autowired
    private CurrencyService currencyService;

    public Mono<List<DetailItem>> findOne(Integer id) {
        return repo.findOne(id);
    }

    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, BigDecimal fromPrice, BigDecimal toPrice,
                                           String unit) {
        // 1. I will add a procedure convert price into numbers fitting with currency such as Euro.
        // 2. The column 'price' cannot handle cents, so we will discuss how to use column for managing price accurately.
        // Default currency is dollar.
        // set current currency
        Mono<List<DetailItem>> list = repo.findList(seek, limit, fromPrice, toPrice);
        Integer minute = LocalTime.now().getMinute();
        if (!unit.equals(currentCurrency)) {
            try {
                return list.map(l -> {
                    return l.stream().map(s -> {
                        BigDecimal d = this.getCurrency(unit, s.getPrice(), minute);
                        return s.copy(d);
                    }).collect(Collectors.toList());
                });
            } catch (Exception e) {
                log.error(e.getMessage());
                return list;
            }
        }
        return list;
    }

    public Mono<List<DetailItem>> findList(Integer seek, Integer limit, Integer locationId) {
        return repo.findList(seek, limit, locationId);
    }

    public Mono<Integer> save(DetailItem item) {
        return repo.save(item);
    }

    public BigDecimal getCurrency(String unit, BigDecimal price, Integer minute) {
        return this.currencyService.getInfo(minute).get(unit).multiply(price);
    }

}
