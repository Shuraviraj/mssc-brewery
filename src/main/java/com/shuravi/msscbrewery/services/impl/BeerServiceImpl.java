package com.shuravi.msscbrewery.services.impl;

import com.shuravi.msscbrewery.services.BeerService;
import com.shuravi.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .build();
    }
}
