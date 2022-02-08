package com.jcdecaux.jcdecauxtest.controller;

import com.jcdecaux.jcdecauxtest.entity.Zone;
import com.jcdecaux.jcdecauxtest.service.PoiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PoiController {

  @Autowired
  PoiService poiService;

  @GetMapping("/getnumberofpoisbyzone/{minLat}/{minLon}")
  public Integer getNumberOfPoisByZone(
    @PathVariable("minLat") float minLat, @PathVariable("minLon") float minLon) {
    return poiService.getNumberOfPoisByZone(minLat, minLon);
  }

  @GetMapping("/getnzonemostdense/{n}")
  public List<Zone> getNZoneMostDense(
    @PathVariable("n") int n) {
    System.out.println();
    return poiService.getNZoneMostDense(n);
  }
}
