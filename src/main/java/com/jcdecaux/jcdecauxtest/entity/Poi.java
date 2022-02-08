package com.jcdecaux.jcdecauxtest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Poi {
  String id;
  float lat;
  float lon;

  @Override
  public String toString() {
    return "Poi{" + "id='" + id + '\'' + ", lat='" + lat + '\'' + ", lon='" + lon + '\'' + '}';
  }
}
