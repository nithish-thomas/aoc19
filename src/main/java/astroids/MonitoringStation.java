package astroids;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MonitoringStation {
    private List<Asteroid> asteroids = new ArrayList<>();
    private int monitorLoc;

    public static MonitoringStation create(String map) {
        final MonitoringStation asteroidMap = new MonitoringStation();

        final String[] mapRows = map.split("\n");

        for (int i = 0, mapRowsLength = mapRows.length; i < mapRowsLength; i++) {
            String aMapRow = mapRows[i];
            for (int j = 0; j < aMapRow.length(); j++) {
                if (aMapRow.charAt(j) == '#') {
                    asteroidMap.asteroids.add(new Asteroid(j, i));
                } else if (aMapRow.charAt(j) == 'X') {
                    asteroidMap.monitorLoc = asteroidMap.asteroids.size();
                    asteroidMap.asteroids.add(new Asteroid(j, i));
                }
            }
        }

        return asteroidMap;
    }

    private static void addSlopesToMultiMap(Multimap<Double, Asteroid> slopes, Asteroid monitoringStation, Asteroid asteroid) {
        final Asteroid currentAsteroid = asteroid;
        double slope = monitoringStation.slope(currentAsteroid)+90;
        slope=slope<0?360+slope:slope;
        slope=slope>360?slope-360:slope;
        slopes.put(slope, currentAsteroid);
    }

    public Asteroid asteroidToBeDestroyedAt(int count) {
        final Asteroid[] asteroids = this.asteroids.toArray(new Asteroid[0]);
        final int totalLength = asteroids.length;
        Multimap<Double, Asteroid> slopes = getSlopeToAsteroidMultimapRotatedByNegetive90Deg(asteroids, totalLength);

        final List<Double> sortedListOfSlopes = slopes.keySet()
          .stream()
          .sorted(Double::compareTo)
          .collect(Collectors.toList());


        final Iterator<Double> cycle = Iterators.cycle(sortedListOfSlopes);

        Asteroid destroyedAsteroid = null;
        for (int i = 1; i <= count && cycle.hasNext(); ) {
            final Double next = cycle.next();
            if (!slopes.containsKey(next)) {
                cycle.remove();
                continue;
            }

            destroyedAsteroid = slopes.get(next).stream().findFirst().get();
            slopes.remove(next, destroyedAsteroid);
            i++;
        }
        return destroyedAsteroid;
    }

    private Multimap<Double, Asteroid> getSlopeToAsteroidMultimapRotatedByNegetive90Deg(Asteroid[] asteroids, int totalLength) {
        Multimap<Double, Asteroid> slopes = ArrayListMultimap.create();
        final Asteroid monitoringStation = asteroids[monitorLoc];
        for (int j = monitorLoc + 1; j < totalLength; j++) {
            addSlopesToMultiMap(slopes, monitoringStation, asteroids[j]);
        }
        for (int j = monitorLoc - 1; j >= 0; j--) {
            addSlopesToMultiMap(slopes, monitoringStation, asteroids[j]);
        }
        return slopes;
    }
}
