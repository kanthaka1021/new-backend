package com.magpie.contoller;


import com.magpie.domain.CombinedInfo;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.jooq.tables.pojos.User;
import com.magpie.service.TestService;
import com.magpie.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("users")
@RestController
@Api(tags = {
        "Users endpoint"
}, description = "A users endpoint", value = "", produces = "application/json")
@Slf4j
public class UserController extends MotherController {
    @Autowired private UserService userserivce;

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @GetMapping("/user/{id}")
    public Mono<ResponseEntity<User>> findUserOne(@PathVariable("id") Integer id) {
        return this.userserivce.findOne(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @GetMapping("/{country}")
    public Mono<ResponseEntity<List<User>>> findAllByCountry(@PathVariable("country") String country) {
        return this.userserivce.findAllByCountry(country, 0, 10)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @PostMapping("/user")
    public Mono<ResponseEntity<Integer>> save(@RequestBody User user) {
        return this.userserivce.save(user)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @PostMapping("/")
    public Mono<ResponseEntity<Long>> saveBulk(@RequestBody List<User> users) {
        return this.userserivce.saveBulk(users)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ApiOperation(value = "", notes = "", response = TestDummy.class)
    @PutMapping("/user")
    public Mono<ResponseEntity<Integer>> update(@RequestBody User user) {
        return this.userserivce.update(user)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }



}
