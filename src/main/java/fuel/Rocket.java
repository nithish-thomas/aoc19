package fuel;

import java.util.List;

public class Rocket {
   private final List<Module> modules;

    public Rocket(List<Module> modules) {
        this.modules = modules;
    }

    public long fuelRequired() {
        return modules.stream().mapToLong(Module::fuelRequirement).sum();
    }


}
