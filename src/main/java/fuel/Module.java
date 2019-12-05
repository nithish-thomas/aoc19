package fuel;

import static java.lang.Math.floorDiv;

public class Module {

    private final int mass;

    public Module(int mass) {
        this.mass = mass;
    }

    public long fuelRequirement() {
        final int moduleFuelRequired = floorDiv(mass, 3) - 2;
        return actualFuelRequirement(moduleFuelRequired);
    }

    private long actualFuelRequirement(long required) {
        long finalFuelWeight = required;
        long additionalWeight = required;
        while (additionFuel(additionalWeight) >=0){
            final long additionalFuel = additionFuel(additionalWeight);
            finalFuelWeight += additionalFuel;
            additionalWeight = additionalFuel;
        }
        return finalFuelWeight;
    }

    private long additionFuel(long required) {
        return Math.floorDiv(required, 3) - 2;
    }

}
