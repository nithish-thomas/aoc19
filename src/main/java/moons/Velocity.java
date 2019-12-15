package moons;

import java.util.Objects;

import static java.lang.Math.abs;

public class Velocity {
    final int x, y, z;

    public Velocity(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Velocity addVelocity(Velocity another) {
        return new Velocity(x+another.x, y+another.y, z+another.z);
    }


    public long kineticEnergy(){
        return abs(x)+abs(y)+abs(z);
    }

    public boolean equalsOnDimension(Velocity o, int dimension) {
        if (this == o) return true;
        switch (dimension){
            case 0: return x == o.x;
            case 1: return y == o.y;
            case 2: return z == o.z;
            default: return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Velocity velocity = (Velocity) o;
        return x == velocity.x &&
          y == velocity.y &&
          z == velocity.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
