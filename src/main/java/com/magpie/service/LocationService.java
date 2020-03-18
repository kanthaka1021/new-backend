package com.magpie.service;

import com.magpie.jooq.tables.pojos.Location;
import com.magpie.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class LocationService {
    @Autowired private LocationRepository repo;

    public Mono<List<Location>> getAll() {
        return repo.getLocations();
    }
}
