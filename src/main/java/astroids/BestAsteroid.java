package astroids;

public class BestAsteroid {
    final Asteroid asteroid;
    final int count;

    public BestAsteroid(Asteroid asteroid, int count) {
        this.asteroid = asteroid;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BestAsteroid{" +
          "asteroid=" + asteroid +
          ", count=" + count +
          '}';
    }
}
