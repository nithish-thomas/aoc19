package astroids;

import java.util.Objects;

import static java.lang.Math.pow;

public class Asteroid {
    private final int x, y;

    public Asteroid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceSquared(Asteroid another) {
        return pow(x - another.x, 2) + pow(y - another.y, 2);
    }

    public double slope(Asteroid o) {
        return Math.atan2(o.y-y, o.x-x)*180/Math.PI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asteroid asteroid = (Asteroid) o;
        return x == asteroid.x &&
          y == asteroid.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Asteroid{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
}
