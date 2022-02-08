package com.jcdecaux.jcdecauxtest.service.impl;

import com.jcdecaux.jcdecauxtest.Data;
import com.jcdecaux.jcdecauxtest.entity.Zone;
import com.jcdecaux.jcdecauxtest.service.PoiService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.jcdecaux.jcdecauxtest.service.Utils;

@Slf4j
@Service
public class PoiServiceImpl implements PoiService {
  public List<Zone> getNZoneMostDense(int n){
    List<Zone> zones = new ArrayList<>();
    for(int i=0;i<n;i++){
      zones.add(Data.numberZoneMap.get(Data.sortedDensity.get(i)));
    }
    return zones;
  }

  public Integer getNumberOfPoisByZone(float minLat, float minLon){
    return Data.zoneNumberMap.get(new Zone(minLat, minLon));
  }

  @PostConstruct
  public void loadData() {
    log.info("loading data...");
    Utils.getPoiFromFile("data.csv", " ");
    Utils.createNumberZoneMapAndSortedList();
    log.info(("loading finished!"));
  }
}
