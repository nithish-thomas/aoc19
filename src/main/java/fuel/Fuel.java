package fuel;

public class Fuel {
    private final long required;

    public Fuel(long required) {
        this.required = required;
    }

    public long actualFuelRequirement() {
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
