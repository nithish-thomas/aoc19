package orbital;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Planet {
    private final String name;
    private final Set<Planet> satellites = new HashSet<>();
    private Planet parent;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Planet> getSatellites() {
        return satellites;
    }

    private int getDirectOrbit(){
        return satellites.size();
    }

    public Planet getParent() {
        return parent;
    }

    public void setParent(Planet parent) {
        this.parent = parent;
    }

    public void addSatellite(Planet planet){
        satellites.add(planet);
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

    private Long totalChild;

    public long getTotal() {
        if(this.totalChild == null) {
            final long totalChild = satellites.stream()
              .mapToLong(satellite -> satellite.getTotal())
              .sum();
            this.totalChild = totalChild;
        }

        return getDirectOrbit()+totalChild;
    }

    @Override
    public String toString() {
        return "Planet{" +
          "name='" + name + '\'' +
          ", total=" + getTotal() +
          '}';
    }
}
