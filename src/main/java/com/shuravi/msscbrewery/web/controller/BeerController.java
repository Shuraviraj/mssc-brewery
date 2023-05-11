package com.shuravi.msscbrewery.web.controller;

import com.shuravi.msscbrewery.services.BeerService;
import com.shuravi.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

  @Autowired
  private BeerService beerService;

  public BeerController(BeerService beerService) {
    this.beerService = beerService;
  }

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
    return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
    var savedDto = beerService.saveNewBeer(beerDto);

    var headers = new HttpHeaders();
    //todo: add hostname to url
    headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());

    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId,
      @RequestBody BeerDto beerDto) {
    beerService.updateBeer(beerId, beerDto);

    return new ResponseEntity(HttpStatus.NO_CONTENT);
  }
}
