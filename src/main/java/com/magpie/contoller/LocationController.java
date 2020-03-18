package com.magpie.contoller;

import com.magpie.jooq.tables.pojos.Location;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.LocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("locations")
@RestController
@Api(tags = "Locations")
@Slf4j
public class LocationController {
    @Autowired private LocationService service;

    @ApiOperation(value = "Find all locations", notes = "", response = TestDummy.class)
    @GetMapping("/locations")
    public Mono<ResponseEntity<List<Location>>> getAll() {
        return this.service.getAll()
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
