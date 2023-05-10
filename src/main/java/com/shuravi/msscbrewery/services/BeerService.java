package com.shuravi.msscbrewery.services;

import com.shuravi.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
