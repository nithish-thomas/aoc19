package wire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class Wire {
    private int currX = 0;
    private int currY = 0;
    private int currStep = 0;
    private Map<Location,Integer> locations = new HashMap<>();

    public Set<Location> getLocations(){
        return new HashSet<>(locations.keySet());
    }

    public Set<Location> intercectsWith(Wire otherWire){
        final Set<Location> intercections = getLocations();
        intercections.retainAll(otherWire.getLocations());
        return intercections;
    }

    public int getMinStepAt(Location location){
        return locations.get(location);
    }


    public static Wire createWireFrom(String wireString){
        final String[] wiringInstructions = parseWire(wireString);

        final Wire wire = new Wire();

        for (String aWiringInstruction: wiringInstructions) {
            final char direction = aWiringInstruction.charAt(0);
            final int length = parseInt(aWiringInstruction.substring(1));
            wire.layWire(direction, length);
        }
        return wire;
    }

    private void layWire(char direction, int length) {
        int incrementX=0, incrementY=0;
        switch (direction){
            case 'R' : incrementX=1; break;
            case 'U' : incrementY=1; break;
            case 'L' : incrementX=-1; break;
            case 'D' : incrementY=-1; break;
            default: throw new IllegalArgumentException("Cannot parse"+ direction +" "+length);
        }

        for (int i = 0; i < length; i++) {
            currX+=incrementX;
            currY+=incrementY;
            locations.putIfAbsent(new Location(currX,currY), ++currStep);
        }
    }


    private static String[] parseWire(String wire) {
        return wire.split(",");
    }
}
