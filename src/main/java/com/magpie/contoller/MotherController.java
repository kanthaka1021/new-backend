package com.magpie.contoller;

import java.net.URI;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

@Slf4j
public class MotherController {

    public <T> Mono<ResponseEntity<T>> buildResponse(Mono<T> t, HttpStatus errorCode, HttpStatus noContentCode) {
        return t.map( r -> new ResponseEntity<>(r, HttpStatus.OK) ).log()
                .doOnError( e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(errorCode))
                .defaultIfEmpty(new ResponseEntity<>(noContentCode));
    }
}

