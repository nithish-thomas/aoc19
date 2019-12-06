package orbital;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Planet {
    private final String name;
    private final Set<Planet> satellite = new HashSet<>();
    private Planet parent;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Planet> getSatellite() {
        return satellite;
    }

    public Planet getParent() {
        return parent;
    }

    public void setParent(Planet parent) {
        this.parent = parent;
    }

    public void addSatellite(Planet planet){
        satellite.add(planet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
