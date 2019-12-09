package com.magpie.contoller;


import com.magpie.domain.WeatherInfo;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("weather")
@RestController
@Api(tags = {
        "Weather API"
}, description = "Test weather API assuming exist on external like internet", value = "", produces = "application/json")
@Slf4j
public class WeatherApi extends MotherController {
    @Autowired private TestService serivce;

    @ApiOperation(value = "get present weather", notes = "", response = TestDummy.class)
    @GetMapping("/present/{id}")
    public Mono<ResponseEntity<WeatherInfo>> get(@PathVariable("id") Integer id) {
        return this.serivce.getWeather(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .doOnError(e -> log.error(ExceptionUtils.getStackTrace(e)))
                .onErrorReturn(new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

}
