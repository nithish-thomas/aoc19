package moons;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoonSimulator {

    private List<Moon> moons = new LinkedList<>();
    private final Velocity[] velocities;

    public MoonSimulator(Moon... moons) {
        this.moons = Arrays.asList(moons);
        velocities = new Velocity[moons.length];
        for (int i = 0; i < velocities.length; i++) {
            velocities[i]= new Velocity(0,0,0);
        }
    }

    public long simulate(){
        long energy=0;
        for (int i = 0; i < moons.size() ; i++) {
            final Moon currentMoon = moons.get(i);
            for (int j = (i+1)%moons.size(); j !=i; j=(j+1)%moons.size()) {
                final Velocity velocity = currentMoon.getInteraction(moons.get(j));
                velocities[i] = velocities[i].addVelocity(velocity);
            }
        }

        for (int i = 0; i < moons.size(); i++) {
            final Moon currentMoon = moons.get(i);
            currentMoon.apply(velocities[i]);
        }

        for (int i = 0; i < moons.size(); i++) {
            energy+=moons.get(i).potentialEnergy()*velocities[i].kineticEnergy();
        }
        return energy;
    }
}
