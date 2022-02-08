package com.jcdecaux.jcdecauxtest.service;

import com.jcdecaux.jcdecauxtest.Data;
import com.jcdecaux.jcdecauxtest.entity.Poi;
import com.jcdecaux.jcdecauxtest.entity.Zone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;


@Slf4j
public class Utils {

  public static void createNumberZoneMapAndSortedList(){
    Data.zoneNumberMap.entrySet().forEach(x -> {
      Data.numberZoneMap.put(x.getValue(), x.getKey());
      Data.sortedDensity.add(x.getValue());
    });
    Collections.sort(Data.sortedDensity, Collections.reverseOrder());
  }



  public static void getPoiFromFile(String path , String delim ) {
    String currLine = "";
    StringTokenizer tokenizer;
    try (BufferedReader br = new BufferedReader(
      new InputStreamReader(ApplicationArguments.class.getResourceAsStream("/" + path )))) {
      while (( currLine = br.readLine()) != null ) {
        tokenizer = new StringTokenizer( currLine , delim );
        while (tokenizer.hasMoreElements()) {
          String id = tokenizer.nextToken();
          if(id.contains("@")){
            continue;//pass the first line
          }
          float lat = Float.parseFloat(tokenizer.nextToken());
          float lon = Float.parseFloat(tokenizer.nextToken());
          Poi poi = new Poi(id, lat, lon);      //create one POI for each line
          Zone zone = calculZoneFromPoi(poi);
          addToZoneMap(zone);
        }

      }
    } catch (IOException e) {
      log.error(e.toString());
      e.printStackTrace();
    }
  }


  public static void addToZoneMap(Zone zone){
    if(zone!=null){
      int count = Data.zoneNumberMap.containsKey(zone) ? Data.zoneNumberMap.get(zone) : 0;
      Data.zoneNumberMap.put(zone, count + 1);
    }
  }

  //calcul Zone where POI inside
  public static Zone calculZoneFromPoi(Poi poi){
    if(-90<=poi.getLat()&&90>=poi.getLat()&&-180<=poi.getLon()&&180>=poi.getLon()){
      return new Zone(getMinLatLon(poi.getLat()), getMinLatLon(poi.getLon()));
    }else{
      log.error(poi.toString()+ "is  not correct POI");
      return null;
    }
  }

  //get minLat or minLon from POI(lat, lon)
  public static float getMinLatLon(float latLon){
    double floor = Math.floor(latLon);
    return (float) (latLon>=floor+0.5?(floor+0.5):floor);
  }
}
