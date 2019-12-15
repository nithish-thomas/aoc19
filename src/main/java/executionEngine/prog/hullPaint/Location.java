package executionEngine.prog.hullPaint;

import java.util.Objects;

public class Location {
    final int x,y;

    public Location(int y, int x) {
        this.x = x;
        this.y = y;
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
}
