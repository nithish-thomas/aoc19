package moons;

import java.util.Objects;

import static java.lang.Math.abs;

public class Moon {
    int x, y, z;

    public Moon(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private static int compare(int x, int x1) {
        return x == x1 ? 0 : (x > x1 ? -1 : 1);
    }

    public Velocity getInteraction(Moon another) {
        return new Velocity(compare(x,another.x), compare(y, another.y), compare(z,another.z));
    }

    public void apply(Velocity velocity){
        this.x+=velocity.x;
        this.y+=velocity.y;
        this.z+=velocity.z;
    }

    public long potentialEnergy(){
        return abs(x)+abs(y)+abs(z);
    }

    public boolean equalsOnDimension(Moon moon, int dimension) {
        if (this == moon) return true;
        switch (dimension){
            case 0: return x == moon.x;
            case 1: return y == moon.y;
            case 2: return z == moon.z;
            default: return false;
        }
    }

    public Moon copy(){
        return new Moon(x,y,z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moon moon = (Moon) o;
        return x == moon.x &&
          y == moon.y &&
          z == moon.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
