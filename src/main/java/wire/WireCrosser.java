package wire;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class WireCrosser {
    public static Optional<Location> minManhattanDistanceIntersection(String wire1String, String wire2String){
        final Wire wire1 = Wire.createWireFrom(wire1String);
        final Wire wire2 = Wire.createWireFrom(wire2String);

        final Set<Location> intercections = wire1.intercectsWith(wire2);

        final Optional<Location> leastLong = intercections.stream()
          .sorted(Comparator.comparingInt(Location::manhattanDistance))
          .findFirst();

        return leastLong;
    }

    public static int minStepIntersection(String wire1String, String wire2String){
        final Wire wire1 = Wire.createWireFrom(wire1String);
        final Wire wire2 = Wire.createWireFrom(wire2String);

        final Set<Location> intercections = wire1.intercectsWith(wire2);

        final Optional<Location> leastLong = intercections.stream()
          .sorted(Comparator.comparingInt(location -> wire1.getMinStepAt(location)+wire2.getMinStepAt(location)))
          .findFirst();

        return  wire1.getMinStepAt(leastLong.get())+wire2.getMinStepAt(leastLong.get());
    }


}
