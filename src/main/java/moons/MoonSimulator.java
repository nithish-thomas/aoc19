package moons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoonSimulator {

    private final List<Moon> moons;
    private final Velocity[] velocities;

    private final List<Moon> initialState;

    public MoonSimulator(Moon... moons) {
        this.moons = Arrays.asList(moons);
        this.initialState = Arrays.stream(moons).map(Moon::copy).collect(Collectors.toList());
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


    public boolean isAtBeginning(int dimension){
        final Velocity zeroVelocity = new Velocity(0, 0, 0);
        for (int i = 0; i < moons.size(); i++) {
            if(!moons.get(i).equalsOnDimension(initialState.get(i), dimension)){
                return false;
            }
            if(!velocities[i].equalsOnDimension(zeroVelocity, dimension)){
                return false;
            }
        }
        return true;
    }
}
