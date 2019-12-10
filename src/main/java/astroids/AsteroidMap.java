package astroids;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AsteroidMap {
    private List<Asteroid> asteroids = new ArrayList<>();

    public static AsteroidMap create(String map) {
        final AsteroidMap asteroidMap = new AsteroidMap();

        final String[] mapRows = map.split("\n");

        for (int i = 0, mapRowsLength = mapRows.length; i < mapRowsLength; i++) {
            String aMapRow = mapRows[i];
            for (int j = 0; j < aMapRow.length(); j++) {
                if (aMapRow.charAt(j) == '#') {
                    asteroidMap.asteroids.add(new Asteroid(j, i));
                }
            }
        }

        return asteroidMap;
    }

    public BestAsteroid best() {
        final Asteroid[] asteroids = this.asteroids.toArray(new Asteroid[0]);
        final int totalLength = asteroids.length;
        Set<Double> currentSlopes = new HashSet<>();
        BestAsteroid bestAsteroid = null;
        for (int i = 0; i < totalLength; i++) {
            Set<Double> slopes = new HashSet<>();
            final Asteroid currentAsteroid = asteroids[i];
            for (int j = i + 1; j != i; j = (j + 1) % totalLength) {
                final double slope = currentAsteroid.slope(asteroids[j%totalLength]);
                slopes.add(slope);
            }
            if (slopes.size() > currentSlopes.size()) {
                currentSlopes = slopes;
                bestAsteroid = new BestAsteroid(currentAsteroid, currentSlopes.size());
            }
        }

        return bestAsteroid;
    }
}
