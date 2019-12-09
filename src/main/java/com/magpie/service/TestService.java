package com.magpie.service;

import com.magpie.domain.CombinedInfo;
import com.magpie.domain.WeatherInfo;
import com.magpie.jooq.tables.pojos.TestDummy;
import com.magpie.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TestService {
    @Autowired
    TestRepository repo;

    @Value("${external.weather.api}")
    private String weatherAPI;

    public Mono<TestDummy> findOne(Integer id) {
        log.info("find one from dummy: "+id);
        return repo.findOne(id);
    }

    public Mono<TestDummy> save(TestDummy dummy) {
        log.info("save an item to the table: "+dummy.toString());
        return repo.save(dummy);
    }

    public Mono<WeatherInfo> getWeather(Integer id) {
        log.info("Get weather by "+id);
        WeatherInfo w = new WeatherInfo();
        w.setDegree(30);
        w.setDegreeUnit("Celsius");
        w.setStatus("cloudy");
        return Mono.just(w);
    }

    // using reactive programing, spring reactor to get two Monos from different resource concurrently.
    public Mono<CombinedInfo> findCombined(Integer id) {
        Mono<TestDummy> dummy = Mono.defer(() -> this.findOne(id));
        Mono<WeatherInfo> weather = getWeatherFromNetwork(id);

        return dummy.zipWith(weather).map(s -> {
            CombinedInfo com = new CombinedInfo();
            com.setEmail(s.getT1().getEmail());
            com.setWeather(s.getT2());
            return com;
        });
    }

    private Mono<WeatherInfo> getWeatherFromNetwork(Integer id) {
        return WebClient.create(weatherAPI+"/"+id).get()
                .retrieve()
                .bodyToMono(WeatherInfo.class)
                .log()
                .doOnError(e -> log.error(e.getMessage()));
    }
}
