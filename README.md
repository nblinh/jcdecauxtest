This is spring boot application. 
After starting the application at localhost. You can use swagger http://localhost:8080/swagger-ui.html to using the APIs.
There are two API:
- calculer the number of POIs in one zone 
http://localhost:8080/swagger-ui.html#!/poi45controller/getNumberOfPoisByZoneUsingGET

- Find the N zones the most density
http://localhost:8080/swagger-ui.html#!/poi45controller/getNZoneMostDenseUsingGET

This project read data from csv with format 
@id @lat @lon
id1 -48.6 -37.7
id2 -27.1 8.4
id3 6.6 -6.9
id4 -2.3 38.3
id5 6.8 -6.9
id6 -2.5 38.3
id7 0.1 -0.1
id8 -2.1 38.1

Each line is one POI: 
Poi {
  String id;
  float lat;
  float lon;
}

each POI is located in one zone 
Zone {
  float minLat;
  float maxLat;
  float minLon;
  float maxLon;
}

maxLat = minLat + 0.5;
maxLon = minLon + 0.5;

This project load data from csv to Map<Zone, Integer> (map zone and number of POI in zone) so we can find directly the number of POIs in zone with the complexity O(1).

We create alse a map Map<Integer, Zone> (map number of POI in zone and zone correspoding) so wen can find directly the zone from the number of POI in zone with complexity O(1).

To find N most density zones, we juste sort the list of density and get the first N zones.

