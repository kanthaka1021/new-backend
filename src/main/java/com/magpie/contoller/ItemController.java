package com.magpie.contoller;


import com.magpie.domain.DetailItem;
import com.magpie.jooq.tables.pojos.Items;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.ItemService;
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
import java.util.List;

@RequestMapping("items")
@RestController
@Api(tags = {
        "Items"
}, description = "An item endpoint", value = "", produces = "application/json")
@Slf4j
public class ItemController extends MotherController {
    @Autowired
    private ItemService serivce;

    @ApiOperation(value = "Find item by id.", notes = "", response = TestDummy.class)
    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<Items>> findOne(@PathVariable("id") Integer id) {
        return this.serivce.findOne(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Find items in price range.", notes = "", response = TestDummy.class)
    @GetMapping("/")
    public Mono<ResponseEntity<List<DetailItem>>> findAll(@RequestParam("seek") Integer seek,
                                                          @RequestParam("limit") Integer limit,
                                                          @RequestParam("from_price") BigDecimal fromPrice,
                                                          @RequestParam("to_price") BigDecimal toPrice,
                                                          @RequestParam("unit") String unit
    ) {
        return this.serivce.findList(seek, limit, fromPrice, toPrice, unit)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Find items by location id", notes = "", response = TestDummy.class)
    @GetMapping("/item/location/")
    public Mono<ResponseEntity<List<DetailItem>>> findAll(@RequestParam("seek") Integer seek,
                                                          @RequestParam("limit") Integer limit,
                                                          @RequestParam("loc_id") Integer locationId) {
        return this.serivce.findList(seek, limit, locationId)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}