package com.magpie.contoller;


import com.magpie.jooq.tables.pojos.Item;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("items")
@RestController
@Api(tags = {
        "Item endpoint"
}, description = "Item endpoint", value = "", produces = "application/json")
@Slf4j
public class ItemController extends MotherController {
    @Autowired private ItemService itemService;

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<Item>> findOneItem(@PathVariable("id") Integer id) {
        return itemService.findOne(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @GetMapping("/item/loc={loc_id}&from={from_id}")
    public Mono<ResponseEntity<List<Result<Record>>>> getNextHundredByLocation(@PathVariable("loc_id") Integer loc_id, @PathVariable("from_id") Integer from_id) {
        return itemService.getNextHundredByLocation(loc_id, from_id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));

    }
}
