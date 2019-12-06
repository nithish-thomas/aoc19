package orbital;

import java.util.HashMap;
import java.util.Map;

public class OrbitalMap {
    private final Planet COM = new Planet("COM");
    private final Map<String, Planet> planetCache = new HashMap<>();

    public OrbitalMap() {
        planetCache.put(COM.getName(), COM);
    }

    public Planet getCOM() {
        return COM;
    }

    public void addPlanet(Planet home, Planet satellite){
        home=planetCache.putIfAbsent(home.getName(), home);
        satellite=planetCache.putIfAbsent(satellite.getName(), satellite);

        home.addSatellite(satellite);
        satellite.setParent(home);
    }

    public static Planet parse(String mapStr) {
        OrbitalMap map = new OrbitalMap();

        final String[] entry = mapStr.split("\\\n");
        for (String anEntry : entry) {
            final String[] planet = anEntry.split("\\)");

            final Planet planet0 = new Planet(planet[0].trim());
            final Planet planet1 = new Planet(planet[1].trim());

            map.addPlanet(planet0, planet1);
        }
        return map.COM;
    }
}
