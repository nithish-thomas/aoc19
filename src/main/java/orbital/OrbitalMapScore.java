package orbital;

import java.util.HashMap;

public class OrbitalMapScore {

    HashMap<Planet, Long> score = new HashMap<>();

    public long calculateCosts(Planet planet) {
        final Long cummulativeScoreForPlanet = score.computeIfAbsent(planet, planetWithoutScore -> {
            final long currPlanetTotal = planet.getTotal();
            final long cummulativeCosts = planet.getSatellites().stream()
              .mapToLong(this::calculateCosts)
              .sum();
            return currPlanetTotal + cummulativeCosts;
        });
        score.putIfAbsent(planet, cummulativeScoreForPlanet);

        return score.get(planet);
    }
}
