package com.jcdecaux.jcdecauxtest;

import com.jcdecaux.jcdecauxtest.entity.Zone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
  //Map density of zone, map (zone, number of poi)
  public static Map<Zone, Integer> zoneNumberMap = new HashMap<>();

  //Map from density to zone, using to get zone form density,
  // map (number of poi, zone)
  public static Map<Integer, Zone> numberZoneMap =  new HashMap<>();

  //list of zone density sorted
  public static List<Integer> sortedDensity = new ArrayList<>();
}
