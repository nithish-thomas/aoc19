package wire;

import java.util.Objects;

import static java.lang.Math.abs;

class Location {
    final int x,y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int manhattanDistance(){
        return abs(x)+abs(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
          y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Location{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
}
