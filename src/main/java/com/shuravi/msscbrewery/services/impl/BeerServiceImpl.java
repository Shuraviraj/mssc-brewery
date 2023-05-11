package com.shuravi.msscbrewery.services.impl;

import com.shuravi.msscbrewery.services.BeerService;
import com.shuravi.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

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

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
    //todo: would add a real impl to update beer
  }
}
