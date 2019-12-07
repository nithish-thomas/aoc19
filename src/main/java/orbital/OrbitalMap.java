package orbital;

import java.util.HashMap;
import java.util.Map;

public class OrbitalMap {
    private final Planet COM = new Planet("COM");
    private final Map<String, Planet> planetCache = new HashMap<>();

    public OrbitalMap() {
        planetCache.put(COM.getName(), COM);
    }

    public Planet getPlanetByName(String planetName){
        return planetCache.get(planetName.trim());
    }

    public static OrbitalMap parse(String mapStr) {
        OrbitalMap orbitalMap = new OrbitalMap();

        final String[] entry = mapStr.split("\\\n");
        for (String anEntry : entry) {
            final String[] planet = anEntry.split("\\)");

            final Planet planet0 = new Planet(planet[0].trim());
            final Planet planet1 = new Planet(planet[1].trim());

            orbitalMap.addPlanet(planet0, planet1);
        }
        return orbitalMap;
    }

    public Planet getCOM() {
        return COM;
    }

    public void addPlanet(Planet home, Planet satellite) {
        planetCache.putIfAbsent(home.getName(), home);
        planetCache.putIfAbsent(satellite.getName(), satellite);

        home = planetCache.get(home.getName());
        satellite = planetCache.get(satellite.getName());

        home.addSatellite(satellite);
        satellite.setParent(home);
    }


}
