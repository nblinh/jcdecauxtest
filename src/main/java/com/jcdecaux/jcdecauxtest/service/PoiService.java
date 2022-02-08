package com.jcdecaux.jcdecauxtest.service;

import com.jcdecaux.jcdecauxtest.entity.Zone;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface PoiService {
  //get n of most dense zones
  public List<Zone> getNZoneMostDense(int n);

  //get number of POIS by zone
  public Integer getNumberOfPoisByZone(float minLat, float minLon);

  //load data from csv and add it to the map
  public void loadData();
}
