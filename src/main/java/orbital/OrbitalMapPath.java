package orbital;

import java.util.HashMap;
import java.util.Map;

public class OrbitalMapPath {
    private Map<Planet, Long> pathCost = new HashMap<>();


    public OrbitalMapPath() {
    }

    public long calculateCost(Planet startPlanet, Planet otherPlanet) {
        Planet currStartPlanet = startPlanet;
        Planet currOtherPlanet = otherPlanet;
        long step = 0;


        while (true) {
            if (currStartPlanet == null && currOtherPlanet == null) {
                throw new IllegalArgumentException("something fishy going on here");
            }
            if (pathCost.containsKey(currStartPlanet)) {
                return step + pathCost.get(currStartPlanet);
            } else if (currStartPlanet != null) {
                pathCost.put(currStartPlanet, step);
                currStartPlanet = currStartPlanet.getParent();
            }

            if (pathCost.containsKey(currOtherPlanet)) {
                return step + pathCost.get(currOtherPlanet);
            } else if (currOtherPlanet != null) {
                pathCost.put(currOtherPlanet, step);
                currOtherPlanet = currOtherPlanet.getParent();
            }

            step++;
        }

    }
}
