package com.magpie.service;

import com.magpie.jooq.tables.pojos.CurrencyInfo;
import com.magpie.repository.CurrencyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    @Autowired private CurrencyInfoRepository repo;

    @Cacheable(value="currency")
    public Map<String, BigDecimal> getInfo(Integer date) {
        Mono<List<CurrencyInfo>> currencyInfo = repo.findAll();
        // turn this mono into hot source with a expiration time.
        return currencyInfo.map(
                s -> s.stream().collect(Collectors.toMap(CurrencyInfo::getUnit, CurrencyInfo::getPrice)))
                .block();
    }

}
