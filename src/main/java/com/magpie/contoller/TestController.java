package com.magpie.contoller;


import com.magpie.domain.CombinedInfo;
import com.magpie.domain.DetailItem;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("test")
@RestController
@Api(tags = {
        "Test endpoint"
}, description = "A test endpoint", value = "", produces = "application/json")
@Slf4j
public class TestController extends MotherController {
    @Autowired private TestService serivce;
    //@Autowired private UserService userserivce;

    @ApiOperation(value = "Find a dummy record.", notes = "", response = TestDummy.class)
    @GetMapping("/dummy/{id}")
    public Mono<ResponseEntity<TestDummy>> findOne(@PathVariable("id") Integer id) {
        return this.serivce.findOne(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Find dummy records.", notes = "", response = TestDummy.class)
    @GetMapping("/dummy")
    public Mono<ResponseEntity<List<TestDummy>>> findAll(@RequestParam("seek") Integer seek,
                                                         @RequestParam("limit") Integer limit,
                                                         @RequestParam("name") String name
    ) {
        return this.serivce.findList(seek, limit, name)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }


    @ApiOperation(value = "Insert a dummy record.", notes = "", response = TestDummy.class)
    @PostMapping("/save")
    public Mono<ResponseEntity<TestDummy>> save(@RequestBody TestDummy dummy) {
        return this.serivce.save(dummy)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "Find info from DB and Internet", notes = "", response = TestDummy.class)
    @GetMapping("/combined/{id}")
    public Mono<ResponseEntity<CombinedInfo>> findCombinedInfo(@PathVariable("id") Integer id) {
        return this.serivce.findCombined(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
