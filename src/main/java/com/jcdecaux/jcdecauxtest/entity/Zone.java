package com.jcdecaux.jcdecauxtest.entity;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
/*
We consider that one zone define by (minLat, minLon) because maxLat = minLat+0.5 and maxLon = minLon+0.5
*/
public class Zone {
  float minLat;
  float maxLat;
  float minLon;
  float maxLon;

  public Zone(float minLat, float minLon){
    this.minLat=minLat;
    this.maxLat=minLat+0.5f;
    this.minLon=minLon;
    this.maxLon=minLon+0.5f;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    final Zone zone = (Zone) o;
    return Float.compare(zone.minLat, minLat) == 0 && Float.compare(zone.minLon, minLon) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(minLat, minLon);
  }
}
