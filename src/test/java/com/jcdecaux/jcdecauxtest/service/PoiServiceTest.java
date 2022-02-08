package com.jcdecaux.jcdecauxtest.service;

import com.jcdecaux.jcdecauxtest.entity.Zone;
import com.jcdecaux.jcdecauxtest.service.impl.PoiServiceImpl;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

@ExtendWith(MockitoExtension.class)
public class PoiServiceTest {
  @InjectMocks
  private PoiServiceImpl poiService;

  @BeforeTestClass
  public void loadData(){
    Utils.getPoiFromFile("data.csv", " ");
    Utils.createNumberZoneMapAndSortedList();
  }

  @Test
  void getNZoneMostDense(){
    //given
    List<Zone> expectZones = Arrays.asList(new Zone(-2.5f, 38f), new Zone(6.5f, -7f));

    //when
    List<Zone> zones = poiService.getNZoneMostDense(2);

    //then
    Assertions.assertEquals(expectZones, zones);
  }

  @Test
  void getNumberOfPoisByZone(){
    //given
    int expectNumOfPois = 2;

    //when
    int numOfPois = poiService.getNumberOfPoisByZone(6.5f, -7f);

    //then
    Assertions.assertEquals(expectNumOfPois, numOfPois);
  }
}
