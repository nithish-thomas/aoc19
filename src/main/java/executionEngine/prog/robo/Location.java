package executionEngine.prog.robo;

import java.util.Objects;

public class Location {
    final int x, y;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public Location newLocation(Direction direction) {
        switch (direction) {
            case UP:
                return new Location(y - 1, x);
            case RIGHT:
                return new Location(y, x + 1);
            case DOWN:
                return new Location(y + 1, x);
            case LEFT:
                return new Location(y, x - 1);
        }
        return null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int manhattanDistance(){
        return Math.abs(x)+Math.abs(y);
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
