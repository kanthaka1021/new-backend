package com.magpie.contoller;


import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RequestMapping("currency")
@RestController
@Api(tags = {
        "Offering current currency."
}, description = "", value = "", produces = "application/json")
@Slf4j
public class CurrencyController extends MotherController {
    @Autowired private CurrencyService service;

    @ApiOperation(value = "internal api for current currency", notes = "", response = TestDummy.class)
    @GetMapping("/{unit}")
    public Mono<ResponseEntity<BigDecimal>> calculateCurrency(@PathVariable("unit") String unit, @RequestParam("price") BigDecimal price) {
        return Mono.just(this.getCurrency(unit, price, 10))
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "external api for current currency", notes = "", response = TestDummy.class)
    @GetMapping("/ext/{unit}")
    public Mono<ResponseEntity<Double>> getInfoFromExternal(@PathVariable("unit") String unit, @RequestParam("price") Double price) {
        return this.getCurrency(unit, price)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    private Mono<Double> getCurrency(String unit, Double price) {
        if( unit.equals("KRW")) {
            return Mono.just(price*1218.00);
        } else if(unit.equals("EUR")) {
            return Mono.just(price*1359.35);
        } else {
            return Mono.error(new Exception("Not matched currency"));
        }
    }

    public BigDecimal getCurrency(String unit, BigDecimal price, Integer min) {
        return this.service.getInfo(min).get(unit).multiply(price);
    }

}
