package com.shuravi.msscbrewery.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.shuravi.msscbrewery.services.impl.BeerServiceImpl;
import com.shuravi.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class BeerControllerTest {

  private static final UUID BEER_ID = UUID.randomUUID();

  private static final BeerDto BEER_DTO = BeerDto.builder()
      .id(BEER_ID)
      .beerName("Test Beer")
      .beerStyle("Test Style")
      .build();

  @Mock
  private BeerServiceImpl beerService;
  private BeerController beerController;

  @BeforeEach
  public void setUp() {
    beerController = new BeerController(beerService);
  }

  @Test
  void testGetBeerById() {
    when(beerService.getBeerById(BEER_ID)).thenReturn(BEER_DTO);

    var response = beerController.getBeer(BEER_ID);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(BEER_DTO);
  }

  @Test
  void handlePost() {
    when(beerService.saveNewBeer(BEER_DTO)).thenReturn(BEER_DTO);

    var response = beerController.handlePost(BEER_DTO);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getHeaders().get("Location")).contains(
        "/api/v1/beer/" + BEER_DTO.getId().toString());

  }

  @Test
  void handleUpdate() {
    var response = beerController.handleUpdate(BEER_ID, BEER_DTO);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }
}