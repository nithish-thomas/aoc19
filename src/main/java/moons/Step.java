package moons;

import java.util.LinkedList;
import java.util.List;

public class Step {
    private List<Moon> moons = new LinkedList<>();
    private List<Velocity> velocities = new LinkedList<>();

    public void add(Moon moon, Velocity velocity) {
        moons.add(moon);
        velocities.add(velocity);
    }
}
